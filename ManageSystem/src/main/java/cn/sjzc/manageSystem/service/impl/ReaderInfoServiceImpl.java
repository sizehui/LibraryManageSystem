package cn.sjzc.manageSystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.sjzc.manageSystem.enums.ResultEnum;
import cn.sjzc.manageSystem.exception.MyException;
import cn.sjzc.manageSystem.mapper.ReaderInfoMapper;
import cn.sjzc.manageSystem.service.ReaderInfoService;
import cn.sjzc.manageSystem.vo.PageBaseVO;
import cn.sjzc.manageSystem.vo.PaymentVO;
import cn.sjzc.manageSystem.vo.ReaderInfoVO;

@Service
@Transactional
public class ReaderInfoServiceImpl implements ReaderInfoService {

	@Autowired
	private ReaderInfoMapper readerInfoMapper;
	
	/**
	 * 新增读者
	 */
	@Override
	public void addReader(ReaderInfoVO reader) {

		//根据cardId判断是否已使用
		String cardId = reader.getCardId();
		if(cardId.length()!=8) {
			throw new MyException(ResultEnum.INVALID_CARD);
		}
		//查询所有读者
		List<ReaderInfoVO> list = readerInfoMapper.selectAllReader(null);
		list.forEach(readerInfo->{
			if(readerInfo.getCardId().equals(cardId)||
					readerInfo.getStudentId().equals(reader.getStudentId())) {
				throw new MyException(ResultEnum.CARD_IS_EXITE);
			}
		});
		
		//设置读者的初始登录密码为 111111
		reader.setPassword("111111");
		int ret = readerInfoMapper.insert(reader);
		if(ret == 0) {
			throw new MyException(ResultEnum.INSERT_FAIL);
		}
		//办理读者卡--》  交押金
		PaymentVO paymentVO = new PaymentVO();
		//TODO 当前用户Id从session取出  暂时写死 
		paymentVO.setChargeMan(123456);
		paymentVO.setPayMan(reader.getReaderId());
		paymentVO.setType(0);
	}

	/**
	 * 删除读者
	 */
	@Override
	public void delReader(int readerId) {
		
		int ret = readerInfoMapper.deleteByPrimaryKey(readerId);
		if(ret == 0) {
			throw new MyException(ResultEnum.DELETE_FAIL);
		}
	}

	/**
	 * 查询所有读者
	 * TODO 条件查询
	 */
	@Override
	public PageBaseVO<ReaderInfoVO> findAllReaders(ReaderInfoVO readerInfo) {
		
		PageHelper.startPage(readerInfo.getPage(), readerInfo.getLimit());// 分页默认值设置
		List<ReaderInfoVO> list = readerInfoMapper.selectAllReader(readerInfo);
		return PageBaseVO.pageBack(list, list);
	}

	/**
	 * 编辑读者信息
	 */
	@Override
	public void editReaderInfo(ReaderInfoVO reader) {

		int ret = readerInfoMapper.updateByPrimaryKeySelective(reader);
		if(ret == 0) {
			throw new MyException(ResultEnum.UPDATE_FAIL);
		}
	}

	/**
	 * 禁用/解禁用户
	 */
	@Override
	public void disabledReader(Map<String,Integer> map) {
		
		int readerId = map.get("readerId");
		int type = map.get("type");
		//type 1-禁用 0-解禁
		if(type == 1) {
			int ret = readerInfoMapper.disabledReader(readerId);
			if(ret == 0) {
				throw new MyException(ResultEnum.UPDATE_FAIL);
			}
		}else if(type == 0) {
			int ret = readerInfoMapper.abledReader(readerId);
			if(ret == 0) {
				throw new MyException(ResultEnum.UPDATE_FAIL);
			}
		}else {
			throw new MyException(ResultEnum.PARAM_ERROR);
		}
	}

	/**
	 * 读者登录后台
	 */
	@Override
	public void readerLogin(String userName, String password) {

		//#注意#  用户名userName 为读者的卡号
		ReaderInfoVO readerInfo = new ReaderInfoVO();
		readerInfo.setCardId(userName);
		List<ReaderInfoVO> list = readerInfoMapper.selectAllReader(readerInfo);
		if(list != null && list.size()>0) {
			if(list.get(0).getPassword().equals(password)) {
				return;
			}else {
				throw new MyException(ResultEnum.AMINDUSER_PASSWORD_INVALID);
			}
		}else {
			throw new MyException(ResultEnum.AMINDUSER_USERNAME_INVALID);
		}
	}

	/**
	 * 读者修改密码
	 */
	@Override
	public void modifyPassword(ReaderInfoVO reader) {

		ReaderInfoVO user = readerInfoMapper.selectById(reader.getReaderId());

		String oldPwd = reader.getOldPwd();// 旧密码
		String newPwd = reader.getNewPwd();// 新密码
		String confirmPwd = reader.getConfirmPwd();// 确认新密码
		
		if (oldPwd.equals(user.getPassword())) {

			if (newPwd.equals(confirmPwd)) {
				int ret = readerInfoMapper.modifyPassword(reader);
				if (ret == 0) {
					throw new MyException(ResultEnum.MODIFY_PASSWORD_FAIL);
				}
			} else {
				//两次输入的密码不一致
				throw new MyException(ResultEnum.PWD_NOT_EQUALS);
			}
		} else {
			//输入的旧密码错误
			throw new MyException(ResultEnum.ENTER_PWD_ERROR);
		}
	}

}
