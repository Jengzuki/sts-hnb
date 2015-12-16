package com.hnb.article;

import org.springframework.stereotype.Component;

@Component
public class ArticleVO {
	 int rcdNo; //글번호
	 int pripNo; //글 그룹
	 String usrName; //작성자
	 String usrMail; //작성자메일
	 String usrSubject; //제목
	 String useContent; // 글내용
	 String usrPass; // 비번
	 String usrFileName; //업로드 파일이름
	 int usrFileSize; //파일사이즈
	 String usrDate; //작성일
	 int usrRefer; //참조횟수
	 int rsdLevel; //레벨
	 int rcdOrder; //레코드 출력순서
	 
	 
	 
	public int getRcdNo() {
		return rcdNo;
	}
	public int getPripNo() {
		return pripNo;
	}
	public String getUsrName() {
		return usrName;
	}
	public String getUsrMail() {
		return usrMail;
	}
	public String getUsrSubject() {
		return usrSubject;
	}
	public String getUsrPass() {
		return usrPass;
	}
	public String getUsrContent() {
		return useContent;
	}
	public String getUsrFileName() {
		return usrFileName;
	}
	public int getUsrFileSize() {
		return usrFileSize;
	}
	public String getUsrDate() {
		return usrDate;
	}
	public int getUsrRefer() {
		return usrRefer;
	}
	public int getRsdLevel() {
		return rsdLevel;
	}
	public int getRcdOrder() {
		return rcdOrder;
	}
	public void setRcdNo(int rcdNo) {
		this.rcdNo = rcdNo;
	}
	public void setPripNo(int pripNo) {
		this.pripNo = pripNo;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public void setUsrMail(String usrMail) {
		this.usrMail = usrMail;
	}
	public void setUsrSubject(String usrSubject) {
		this.usrSubject = usrSubject;
	}
	public void setUsrPass(String usrPass) {
		this.usrPass = usrPass;
	}
	public void setUsrContent(String usrContent) {
		this.useContent = usrContent;
	}
	public void setUsrFileName(String usrFileName) {
		this.usrFileName = usrFileName;
	}
	public void setUsrFileSize(int usrFileSize) {
		this.usrFileSize = usrFileSize;
	}
	public void setUsrDate(String usrDate) {
		this.usrDate = usrDate;
	}
	public void setUsrRefer(int usrRefer) {
		this.usrRefer = usrRefer;
	}
	public void setRsdLevel(int rsdLevel) {
		this.rsdLevel = rsdLevel;
	}
	public void setRcdOrder(int rcdOrder) {
		this.rcdOrder = rcdOrder;
	}
	 
	 
}
