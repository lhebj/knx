package com.knx.web.dto;
public class NewsDTO {
	private Long idN;
	private String titleN;
	private String contentN;
	private String pic;
	private String picName;
	private String dateCreateN;
	public Long getIdN() {
		return idN;
	}
	public void setIdN(Long idN) {
		this.idN = idN;
	}
	public String getTitleN() {
		return titleN;
	}
	public void setTitleN(String titleN) {
		this.titleN = titleN;
	}
	public String getContentN() {
		return contentN;
	}
	public void setContentN(String contentN) {
		this.contentN = contentN;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public String getDateCreateN() {
		return dateCreateN;
	}
	public void setDateCreateN(String dateCreateN) {
		this.dateCreateN = dateCreateN;
	}
	
}
