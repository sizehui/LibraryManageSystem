package cn.sjzc.manageSystem.vo;

import cn.sjzc.manageSystem.model.ReaderInfo;

public class ReaderInfoVO extends ReaderInfo{

	private String oldPwd;
	
	private String newPwd;
	
	private String confirmPwd;
	
	private int chargeMan;

	private int page;
	
	private int limit;
	
	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getChargeMan() {
		return chargeMan;
	}

	public void setChargeMan(int chargeMan) {
		this.chargeMan = chargeMan;
	}
	
}