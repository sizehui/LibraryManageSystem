package cn.sjzc.manageSystem.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sjzc.manageSystem.enums.ResultEnum;
import cn.sjzc.manageSystem.util.R;
import cn.sjzc.manageSystem.vo.ResultVO;


@ControllerAdvice(basePackages="cn.sjzc.manageSystem.controller")
public class CatchException {

	private final static Logger logger = LoggerFactory.getLogger(CatchException.class);

	@ExceptionHandler(value= Exception.class)
	@ResponseBody
	public ResultVO handle(Exception e) {
		if(e instanceof MyException) {
			MyException ce = (MyException) e;
			return R.fail(ce.getCode(), ce.getMessage());		
		}else {
			logger.error("系统异常{}",e);
			return R.fail(ResultEnum.SYSTEM_ERROR);
		}
	}
}