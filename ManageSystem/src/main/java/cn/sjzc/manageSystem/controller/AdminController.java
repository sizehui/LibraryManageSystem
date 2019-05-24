package cn.sjzc.manageSystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sjzc.manageSystem.controller.base.BaseController;
import cn.sjzc.manageSystem.model.Admin;
import cn.sjzc.manageSystem.service.AdminService;
import cn.sjzc.manageSystem.util.R;
import cn.sjzc.manageSystem.vo.ResultVO;

@RestController
public class AdminController extends BaseController{
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * @methodName 
	 * @description 新增管理员
	 */
	@RequestMapping(value="/admin/addAdmin",method=RequestMethod.POST)
	public ResultVO addAdmin(@RequestBody Admin admin) {
		
		adminService.insertAdmin(admin);
		return R.success();
	}
	
	/**
	 * @methodName 
	 * @description 删除管理员 
	 */
	@RequestMapping(value="/admin/delAdmin",method=RequestMethod.DELETE)
	public ResultVO delAdmin(@RequestBody Map<String,Integer> map) {
		
		adminService.delAdmin(map.get("adminId"));
		return R.success();
	}
	
	/**
	 * @methodName 
	 * @description 查询所有管理员
	 */
	@RequestMapping(value="/admin/findAllAdmin",method=RequestMethod.GET)
	public ResultVO findAllAdmin() {
		
		List<Admin> list = adminService.findAllAdmin();
		return R.success(list);
	}
	
	/**
	 * @methodName 
	 * @description 根据Id查询 
	 */
	@RequestMapping(value="/admin/selectById",method=RequestMethod.GET)
	public ResultVO selectById(int adminId) {
		
		return R.success(adminService.selectById(adminId));
	}
	/**
	 * @methodName 
	 * @description 编辑管理员 
	 */
	@RequestMapping(value="/admin/editAdmin",method=RequestMethod.POST)
	public ResultVO editAdmin(@RequestBody Admin admin) {
		
		adminService.editAdmin(admin);
		return R.success();
	}
	
	/**
	 * @methodName 
	 * @description 读者登录后台系统 
	 */
	@RequestMapping(value="/admin/adminLogin",method=RequestMethod.POST)
	public ResultVO readerLogin(@RequestBody Map<String,String> map) {
		
		String userName = map.get("userName");
		String password = map.get("password");
		
		adminService.adminLogin(userName, password);
		return R.success(map.get("type"));
	}
}
