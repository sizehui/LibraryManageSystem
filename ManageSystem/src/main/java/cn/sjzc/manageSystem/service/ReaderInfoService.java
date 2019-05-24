package cn.sjzc.manageSystem.service;

import java.util.Map;

import cn.sjzc.manageSystem.vo.PageBaseVO;
import cn.sjzc.manageSystem.vo.ReaderInfoVO;

public interface ReaderInfoService {

	//新增读者
	void addReader(ReaderInfoVO reader);
	
	//删除读者
	void delReader(int readerId);
	
	//查询所有读者
	PageBaseVO<ReaderInfoVO> findAllReaders(ReaderInfoVO readerInfo);
	
	//编辑读者信息
	void editReaderInfo(ReaderInfoVO reader);
	
	//禁用/解禁用户
	void disabledReader(Map<String,Integer> map);
	
	//读者登录后台管理系统
	void readerLogin(String userName,String password);
	
	//读者修改密码
	void modifyPassword(ReaderInfoVO reader);
}
