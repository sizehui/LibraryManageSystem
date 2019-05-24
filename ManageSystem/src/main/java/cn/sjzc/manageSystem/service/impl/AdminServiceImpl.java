package cn.sjzc.manageSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sjzc.manageSystem.enums.ResultEnum;
import cn.sjzc.manageSystem.exception.MyException;
import cn.sjzc.manageSystem.mapper.AdminMapper;
import cn.sjzc.manageSystem.model.Admin;
import cn.sjzc.manageSystem.service.AdminService;

/**
 * @className
 * @description
 * @date 2019年4月17日
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	/**
	 * 新增管理员
	 */
	@Override
	public void insertAdmin(Admin admin) {

		// 查询所有管理员
		List<Admin> list = adminMapper.selectAllAdmins();
		list.forEach(admins -> {
			if (admins.getUsername().equals(admin.getUsername())) {
				throw new MyException(ResultEnum.ADMINUSER_EXITE);
			}
		});
		int ret = adminMapper.insert(admin);
		if (ret == 0) {
			throw new MyException(ResultEnum.INSERT_FAIL);
		}
	}

	/**
	 * 删除管理员
	 */
	@Override
	public void delAdmin(int adminId) {

		int ret = adminMapper.deleteByPrimaryKey(adminId);
		if (ret == 0) {
			throw new MyException(ResultEnum.DELETE_FAIL);
		}
	}

	/**
	 * 查询所有管理员
	 */
	@Override
	public List<Admin> findAllAdmin() {

		List<Admin> list = adminMapper.selectAllAdmins();
		return list;
	}

	/**
	 * 编辑管理员
	 */
	@Override
	public void editAdmin(Admin admin) {

		int ret = adminMapper.updateByPrimaryKeySelective(admin);
		if (ret == 0) {
			throw new MyException(ResultEnum.UPDATE_FAIL);
		}
	}

	/**
	 * 管理员登录后台
	 */
	@Override
	public void adminLogin(String userName, String password) {

		Admin admin = adminMapper.selectByUserName(userName);
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				return;
			} else {
				throw new MyException(ResultEnum.AMINDUSER_PASSWORD_INVALID);
			}
		} else {
			throw new MyException(ResultEnum.ADMINUSER_NOT_EXITE);
		}
	}

	/**
	 * 根据Id查询
	 */
	@Override
	public Admin selectById(int adminId) {

		Admin admin = adminMapper.selectById(adminId);
		return admin;
	}

}
