package cn.sjzc.manageSystem.enums;

public enum ResultEnum {

	PARAM_ERROR(500,"参数不合法"),
	SYSTEM_ERROR(500,"系统异常"),
	INSERT_FAIL(500,"插入失败"),
	DELETE_FAIL(500,"删除失败"),
	CARD_IS_EXITE(500,"该卡号已被读者使用"),
	INVALID_CARD(500,"无效的卡号"),
	PARAMETER_ISNULL(500,"参数为空"),
	USERID_NOT_EXITE(500,"用户不存在"),
	ADMINUSER_EXITE(500,"该管理员已存在"),
	ADMINUSER_NOT_EXITE(500,"该管理员不存在"),
	ADMINLIST_ISNULL(500,"管理员列表为空"),
	NOTICEMESSAGE_NOT_EXITE(500,"该消息不存在"),
	AMINDUSER_PASSWORD_INVALID(500,"用户密码不正确！"),
	AMINDUSER_USERNAME_INVALID(500,"不存在该用户！"),
    SELECT_NO(500,"查询数据失败"),
    SELECT_RESULT_NULL(500,"查询结果为空"),
	UPDATE_FAIL(500,"更新失败"),
	MODIFY_PASSWORD_FAIL(500,"修改密码失败"),
	PWD_NOT_EQUALS(500,"两次输入的密码不一致"),
	ENTER_PWD_ERROR(500,"输入的旧密码错误"),
	;

	
	private Integer code;
	private String msg;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	ResultEnum(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
}
