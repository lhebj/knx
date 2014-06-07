package com.knx.web.dto;

public class TrainingDTO {
	private Long idTra;
	private String titleTra;
	private String contentTra;
	private String pic;
	private String picName;
	private String dateCreateTra;
	public Long getIdTra() {
		return idTra;
	}
	public void setIdTra(Long idTra) {
		this.idTra = idTra;
	}
	public String getTitleTra() {
		return titleTra;
	}
	public void setTitleTra(String titleTra) {
		this.titleTra = titleTra;
	}
	public String getContentTra() {
		return contentTra;
	}
	public void setContentTra(String contentTra) {
		this.contentTra = contentTra;
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
	public String getDateCreateTra() {
		return dateCreateTra;
	}
	public void setDateCreateTra(String dateCreateTra) {
		this.dateCreateTra = dateCreateTra;
	}
}
