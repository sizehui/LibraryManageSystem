package cn.sjzc.manageSystem.mapper;

import java.util.List;

import cn.sjzc.manageSystem.model.Admin;

public interface AdminMapper {
    
	//删除管理员
    int deleteByPrimaryKey(int adminId);

    //增加管理员
    int insert(Admin record);

    //查询所有管理员
    List<Admin> selectAllAdmins();
    
    //编辑管理员
    int updateByPrimaryKeySelective(Admin record);
    
    //根据userName查询管理员
    Admin selectByUserName(String userName);
    
    //根据id查询
    Admin selectById(int adminId);
}