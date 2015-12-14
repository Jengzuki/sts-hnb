package com.hnb.global;

public class Command implements Orderable{
	private String column, keyword; 
	private int pageNo, start, end;
	public final int PAGESIZE = 5;
	public Command(
			String pageNo
			) {
		this.pageNo = Integer.parseInt(pageNo);
		this.start = (Integer.parseInt(pageNo)-1)*PAGESIZE;
		this.end = (Integer.parseInt(pageNo)*PAGESIZE);
	}

	public Command(
			String clumn,
			String keyword,
			String pageNo
			) {
		this.column = clumn;
		this.keyword = keyword;
		this.pageNo = Integer.parseInt(pageNo);
		this.start = (Integer.parseInt(pageNo)-1)*PAGESIZE;
		this.end = (Integer.parseInt(pageNo)*PAGESIZE);
	}
	
	public String getColumn() {
		return column;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPageNo() {
		return pageNo;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public void setEnd(int end) {
		this.end = end;
	}


	@Override
	public void execute() {}
	
	
}
