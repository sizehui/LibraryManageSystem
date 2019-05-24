package cn.sjzc.manageSystem.service;

import cn.sjzc.manageSystem.vo.BookInfoVO;
import cn.sjzc.manageSystem.vo.PageBaseVO;

public interface BookInfoService {

	// 新增图书
	void insert(BookInfoVO record);

	// 删除图书
	void deleteById(int bookId);

	// 查看图书详情
	BookInfoVO findDetails(int bookId);

	// 查询所有图书（条件查询）
	PageBaseVO<BookInfoVO> findAllBooks(BookInfoVO bookInfoVO);

	// 编辑图书
	void updateById(BookInfoVO record);
}
