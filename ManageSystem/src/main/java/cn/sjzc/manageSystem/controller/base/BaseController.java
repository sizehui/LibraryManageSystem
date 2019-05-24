package cn.sjzc.manageSystem.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.sjzc.manageSystem.util.Const;

public class BaseController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
		
	public BaseController() {
	}
	
	public Integer getUserId() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return (Integer) request.getSession().getAttribute(Const.USER_SESSION);
	}
	
}
