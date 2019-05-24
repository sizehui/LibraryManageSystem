package cn.sjzc.manageSystem.vo;

import java.util.Date;

public class PaymentVO {

	private int chargeMan;
	
	private int payMan;
	
	private int type;
	
	private int paymentId;
	
	private Date payTime;

	public int getChargeMan() {
		return chargeMan;
	}

	public void setChargeMan(int chargeMan) {
		this.chargeMan = chargeMan;
	}

	public int getPayMan() {
		return payMan;
	}

	public void setPayMan(int payMan) {
		this.payMan = payMan;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	
}
