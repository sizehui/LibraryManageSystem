package cn.sjzc.manageSystem.model;

import java.util.Date;

public class LendList {
    private Long serNum;

    private Long bookId;

    private Long readerId;

    private Date lendDate;

    private Date dueTime;
    
    private Date backDate;

    private int renewState;
    
    private int overdue;
    
    private int operator;
    
    public Date getDueTime() {
		return dueTime;
	}

	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}

	public int getRenewState() {
		return renewState;
	}

	public void setRenewState(int renewState) {
		this.renewState = renewState;
	}

	public int getOverdue() {
		return overdue;
	}

	public void setOverdue(int overdue) {
		this.overdue = overdue;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public Long getSerNum() {
        return serNum;
    }

    public void setSerNum(Long serNum) {
        this.serNum = serNum;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }
}