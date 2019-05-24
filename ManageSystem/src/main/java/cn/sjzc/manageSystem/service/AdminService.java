package cn.sjzc.manageSystem.service;

import java.util.List;

import cn.sjzc.manageSystem.model.Admin;

public interface AdminService {

	//新增管理员
    void insertAdmin(Admin admin);
    
    //删除管理员
    void delAdmin(int adminId);
    
    //查询所有管理员
    List<Admin> findAllAdmin();
    
    //根据id查询
    Admin selectById(int adminId);
    
    //编辑管理员
    void editAdmin(Admin admin);

    //管理员后台登录
	void adminLogin(String userName, String password);
}
