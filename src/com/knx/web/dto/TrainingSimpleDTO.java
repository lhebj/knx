package com.knx.web.dto;

public class TrainingSimpleDTO {
	private Long idTra;
	private String titleTra;
	private Boolean showNew;
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
	public Boolean getShowNew() {
		return showNew;
	}
	public void setShowNew(Boolean showNew) {
		this.showNew = showNew;
	}
}
