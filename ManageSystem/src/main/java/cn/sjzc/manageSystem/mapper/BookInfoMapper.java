package cn.sjzc.manageSystem.mapper;

import java.util.List;

import cn.sjzc.manageSystem.vo.BookInfoVO;

public interface BookInfoMapper {
	
	//新增图书
	int insert(BookInfoVO record);
	
	//删除图书
	int deleteById(int bookId);
	
	//查看图书详情
	BookInfoVO findDetails(int bookId);
	
	//查询所有图书（条件查询）
	List<BookInfoVO> findAllBooks(BookInfoVO bookInfoVO);
	
	//编辑图书
	int updateById(BookInfoVO record);
}