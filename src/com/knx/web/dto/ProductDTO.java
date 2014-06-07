package com.knx.web.dto;



public class ProductDTO {

	private Long idPrd;
	private String namePrd;
	private String modelPrd;
	private String logoPath;
	private String logoName;
	public Long getIdPrd() {
		return idPrd;
	}
	public void setIdPrd(Long idPrd) {
		this.idPrd = idPrd;
	}
	public String getNamePrd() {
		return namePrd;
	}
	public void setNamePrd(String namePrd) {
		this.namePrd = namePrd;
	}
	public String getModelPrd() {
		return modelPrd;
	}
	public void setModelPrd(String modelPrd) {
		this.modelPrd = modelPrd;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public String getLogoName() {
		return logoName;
	}
	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}
	
}
