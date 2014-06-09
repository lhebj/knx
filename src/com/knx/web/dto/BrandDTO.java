package com.knx.web.dto;


public class BrandDTO {
	
	private Long idBrd;
	private String nameBrd;
	private String initialsBrd;
	private Boolean show;
	public Long getIdBrd() {
		return idBrd;
	}
	public void setIdBrd(Long idBrd) {
		this.idBrd = idBrd;
	}
	public String getNameBrd() {
		return nameBrd;
	}
	public void setNameBrd(String nameBrd) {
		this.nameBrd = nameBrd;
	}
	public String getInitialsBrd() {
		return initialsBrd;
	}
	public void setInitialsBrd(String initialsBrd) {
		this.initialsBrd = initialsBrd;
	}
	public Boolean getShow() {
		return show;
	}
	public void setShow(Boolean show) {
		this.show = show;
	}


}
