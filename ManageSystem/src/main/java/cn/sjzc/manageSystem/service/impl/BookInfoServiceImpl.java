package cn.sjzc.manageSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.sjzc.manageSystem.enums.ResultEnum;
import cn.sjzc.manageSystem.exception.MyException;
import cn.sjzc.manageSystem.mapper.BookInfoMapper;
import cn.sjzc.manageSystem.service.BookInfoService;
import cn.sjzc.manageSystem.vo.BookInfoVO;
import cn.sjzc.manageSystem.vo.PageBaseVO;

@Service
@Transactional
public class BookInfoServiceImpl implements BookInfoService {

	@Autowired
	private BookInfoMapper bookInfoMapper;

	/**
	 * 新增图书
	 */
	@Override
	public void insert(BookInfoVO record) {

		//检验图书编号合法性
		String 
		int ret = bookInfoMapper.insert(record);
		if (ret == 0) {
			throw new MyException(ResultEnum.INSERT_FAIL);
		}
	}

	/**
	 * 删除图书
	 */
	@Override
	public void deleteById(int bookId) {

		int ret = bookInfoMapper.deleteById(bookId);
		if (ret == 0) {
			throw new MyException(ResultEnum.DELETE_FAIL);
		}
	}

	/**
	 * 查看图书详情
	 */
	@Override
	public BookInfoVO findDetails(int bookId) {

		BookInfoVO bookInfo = bookInfoMapper.findDetails(bookId);
		return bookInfo;
	}

	/**
	 * 条件查询所有图书
	 */
	@Override
	public PageBaseVO<BookInfoVO> findAllBooks(BookInfoVO bookInfoVO) {

		PageHelper.startPage(bookInfoVO.getPage(), bookInfoVO.getLimit());
		List<BookInfoVO> list = bookInfoMapper.findAllBooks(bookInfoVO);
		return PageBaseVO.pageBack(list,list);
	}

	/**
	 * 编辑图书
	 */
	@Override
	public void updateById(BookInfoVO record) {

		int ret = bookInfoMapper.updateById(record);
		if(ret == 0) {
			throw new MyException(ResultEnum.UPDATE_FAIL);
		}
	}
}
