package cn.sjzc.manageSystem.util;

import java.util.HashMap;
import java.util.Map;

import cn.sjzc.manageSystem.enums.ResultEnum;
import cn.sjzc.manageSystem.vo.PageBaseVO;
import cn.sjzc.manageSystem.vo.ResultVO;

public class R {

	public  static ResultVO success(Object obj) {
	
		ResultVO rvo = new ResultVO();
		rvo.setCode(0);
		rvo.setMsg("成功");
		rvo.setData(obj);
		return rvo;
	}
	
	public  static ResultVO success() {
		ResultVO rvo = new ResultVO();
		rvo.setCode(0);
		rvo.setMsg("成功");
		rvo.setData(null);
		return rvo;
	}
	
	public  static ResultVO fail(int code, String msg) {
		ResultVO rvo = new ResultVO();
		rvo.setCode(code);
		rvo.setMsg(msg);
		rvo.setData(null);
		return rvo;
	}
	
	public  static ResultVO fail(ResultEnum resultEnum) {
		ResultVO rvo = new ResultVO();
		rvo.setCode(resultEnum.getCode());
		rvo.setMsg(resultEnum.getMsg());
		rvo.setData(null);
		return rvo;
	}
	
	public  static Map<String,Object> success(PageBaseVO<?> pageBaseVO) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("code", 0);
		map.put("msg", "成功");
		map.put("count", pageBaseVO.getCount());
		map.put("data", pageBaseVO.getData());
		return map;	
	}
}
