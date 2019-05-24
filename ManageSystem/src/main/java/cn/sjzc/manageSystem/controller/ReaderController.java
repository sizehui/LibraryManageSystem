package cn.sjzc.manageSystem.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sjzc.manageSystem.controller.base.BaseController;
import cn.sjzc.manageSystem.service.ReaderInfoService;
import cn.sjzc.manageSystem.util.R;
import cn.sjzc.manageSystem.vo.ReaderInfoVO;
import cn.sjzc.manageSystem.vo.ResultVO;

@RestController
public class ReaderController extends BaseController{
	
	@Autowired
	private ReaderInfoService readerInfoService;
	
	/**
	 * @methodName 
	 * @description 新增读者 
	 */
	@RequestMapping(value="/reader/addReader",method=RequestMethod.POST)
	public ResultVO addReader(@RequestBody ReaderInfoVO readerInfo) {
		
		//TODO 从session取userId暂时写死  
		readerInfo.setChargeMan(123456);
		readerInfoService.addReader(readerInfo);
		return R.success();
	}
	
	/**
	 * @methodName 
	 * @description 删除读者 
	 */
	@RequestMapping(value="/reader/delReader",method=RequestMethod.DELETE)
	public ResultVO delReader(@RequestBody Map<String,Integer> map) {
		
		readerInfoService.delReader(map.get("readerId"));
		return R.success();
	}
	
	/**
	 * @methodName 
	 * @description 编辑读者 
	 */
	@RequestMapping(value="/reader/editReader",method=RequestMethod.POST)
	public ResultVO editReader(@RequestBody ReaderInfoVO readerInfo) {
		
		readerInfoService.editReaderInfo(readerInfo);
		return R.success();
	}
	
	/**
	 * @methodName 
	 * @param name cardId
	 * @description 查询所有读者
	 */
	@RequestMapping(value="/reader/findAllReader",method=RequestMethod.POST)
	public Map<String, Object> findAllReader(@RequestBody ReaderInfoVO readerInfo) {
		
		return R.success(readerInfoService.findAllReaders(readerInfo));
	}
	
	/**
	 * @methodName 
	 * @param type readerId
	 * @description 禁用/解禁用户 
	 */
	@RequestMapping(value="/reader/disabledReader",method=RequestMethod.POST)
	public ResultVO disabledReader(@RequestBody Map<String,Integer> map) {
		
		readerInfoService.disabledReader(map);
		return R.success();
	}
	
	/**
	 * @methodName 
	 * @description 读者登录后台系统 
	 */
	@RequestMapping(value="/reader/readerLogin",method=RequestMethod.POST)
	public ResultVO readerLogin(@RequestBody Map<String,String> map) {
		
		String userName = map.get("userName");
		String password = map.get("password");
		
		readerInfoService.readerLogin(userName, password);
		return R.success(map.get("type"));
	}
	
	/**
	 * @methodName 
	 * @param oldPwd newPwd configPwd readerId
	 * @description 读者修改密码 
	 */
	@RequestMapping(value="/reader/modifyPassword",method=RequestMethod.POST)
	public ResultVO modifyPassWord(@RequestBody ReaderInfoVO reader) {
		
		readerInfoService.modifyPassword(reader);
		return R.success();
	}
}
