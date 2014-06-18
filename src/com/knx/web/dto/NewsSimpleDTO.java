package com.knx.web.dto;

public class NewsSimpleDTO {
	private Long idN;
	private String titleN;
	private Boolean showNew;
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
	public Boolean getShowNew() {
		return showNew;
	}
	public void setShowNew(Boolean showNew) {
		this.showNew = showNew;
	}
	
}
