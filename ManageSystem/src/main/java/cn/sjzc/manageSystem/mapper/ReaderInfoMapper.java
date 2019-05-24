package cn.sjzc.manageSystem.mapper;

import java.util.List;

import cn.sjzc.manageSystem.vo.PaymentVO;
import cn.sjzc.manageSystem.vo.ReaderInfoVO;

public interface ReaderInfoMapper {

	//删除读者
    int deleteByPrimaryKey(int readerId);

    //新增读者
    int insert(ReaderInfoVO record);

    //查询所有读者
    List<ReaderInfoVO> selectAllReader(ReaderInfoVO readerInfo);

    //根据读者id查询信息
    ReaderInfoVO selectById(int readerId);
    
    //更新读者信息
    int updateByPrimaryKeySelective(ReaderInfoVO record);

    //新增读者卡缴费记录
    int addCardPay(PaymentVO paymentVO);
    
    //禁用读者
    int disabledReader(int readerId);
    
    //解禁读者
    int abledReader(int readerId);
    
    //读者修改密码 modifyPassword
    int modifyPassword(ReaderInfoVO record);
}