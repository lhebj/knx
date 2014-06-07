package com.knx.web.dto;


public class ProductDownloadDTO {
	private Long idPrdl;
	private String namePrdl;
	private String fileNamePrdl;
	private String filePathPrdl;
	private String dateCreatePrdl;
	public Long getIdPrdl() {
		return idPrdl;
	}
	public void setIdPrdl(Long idPrdl) {
		this.idPrdl = idPrdl;
	}
	public String getNamePrdl() {
		return namePrdl;
	}
	public void setNamePrdl(String namePrdl) {
		this.namePrdl = namePrdl;
	}
	public String getFileNamePrdl() {
		return fileNamePrdl;
	}
	public void setFileNamePrdl(String fileNamePrdl) {
		this.fileNamePrdl = fileNamePrdl;
	}
	public String getFilePathPrdl() {
		return filePathPrdl;
	}
	public void setFilePathPrdl(String filePathPrdl) {
		this.filePathPrdl = filePathPrdl;
	}
	public String getDateCreatePrdl() {
		return dateCreatePrdl;
	}
	public void setDateCreatePrdl(String dateCreatePrdl) {
		this.dateCreatePrdl = dateCreatePrdl;
	}
}
