package cn.sjzc.manageSystem.vo;

import cn.sjzc.manageSystem.model.BookInfo;

public class BookInfoVO extends BookInfo {

	private int page;

	private int limit;

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

}