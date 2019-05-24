package cn.sjzc.manageSystem.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sjzc.manageSystem.service.BookInfoService;
import cn.sjzc.manageSystem.util.R;
import cn.sjzc.manageSystem.vo.BookInfoVO;
import cn.sjzc.manageSystem.vo.ResultVO;

@RestController
public class BookInfoController {

	@Autowired
	private BookInfoService bookInfoService;
	
	/**
	 * @methodName 
	 * @description 新增图书 
	 */
	@RequestMapping(value="/book/addBook",method=RequestMethod.POST)
	public ResultVO addBook(@RequestBody BookInfoVO bookInfo) {
		
		bookInfoService.insert(bookInfo);
		return R.success();
	}
	
	
	/**
	 * @methodName 
	 * @description 删除图书 
	 */
	@RequestMapping(value="/book/delBook",method=RequestMethod.DELETE)
	public ResultVO delBook(@RequestBody Map<String,Integer> map) {
		
		bookInfoService.deleteById(map.get("bookId"));
		return R.success();
	}
	
	/**
	 * @methodName 
	 * @description 查看详情 
	 */
	@RequestMapping(value="/book/findDetails",method=RequestMethod.GET)
	public ResultVO findDetails(int bookId) {
		
		return R.success(bookInfoService.findDetails(bookId));
	}
	
	/**
	 * @methodName 
	 * @description 查看所有书 
	 */
	@RequestMapping(value="/book/findAllBooks",method=RequestMethod.POST)
	public Map<String, Object> findAllBooks(@RequestBody BookInfoVO bookInfoVO) {
		
		return R.success(bookInfoService.findAllBooks(bookInfoVO));
	}
	
	/**
	 * @methodName 
	 * @description 编辑图书 
	 */
	@RequestMapping(value="/book/updateById",method=RequestMethod.POST)
	public ResultVO updateById(@RequestBody BookInfoVO bookInfoVO) {
		
		bookInfoService.updateById(bookInfoVO);
		return R.success();
	}
	
}