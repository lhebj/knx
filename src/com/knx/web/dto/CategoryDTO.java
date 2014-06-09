package com.knx.web.dto;

public class CategoryDTO {

	private Long idCat;
	private String nameCat;
	private String initialsCat;
	private Boolean show;
	public Long getIdCat() {
		return idCat;
	}
	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getNameCat() {
		return nameCat;
	}
	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	public String getInitialsCat() {
		return initialsCat;
	}
	public void setInitialsCat(String initialsCat) {
		this.initialsCat = initialsCat;
	}
	public Boolean getShow() {
		return show;
	}
	public void setShow(Boolean show) {
		this.show = show;
	}

	
}
