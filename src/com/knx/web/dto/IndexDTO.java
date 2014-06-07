package com.knx.web.dto;

public class IndexDTO {
	
	public Long idIdx;
	public String typeIdx;
	public String path;
	public String playcodeIdx;
	public String positionIdx;
	private String linkIdx;
	
	
	public Long getIdIdx() {
		return idIdx;
	}
	public void setIdIdx(Long idIdx) {
		this.idIdx = idIdx;
	}
	public String getTypeIdx() {
		return typeIdx;
	}
	public void setTypeIdx(String typeIdx) {
		this.typeIdx = typeIdx;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPlaycodeIdx() {
		return playcodeIdx;
	}
	public void setPlaycodeIdx(String playcodeIdx) {
		this.playcodeIdx = playcodeIdx;
	}
	public String getPositionIdx() {
		return positionIdx;
	}
	public void setPositionIdx(String positionIdx) {
		this.positionIdx = positionIdx;
	}
	public String getLinkIdx() {
		return linkIdx;
	}
	public void setLinkIdx(String linkIdx) {
		this.linkIdx = linkIdx;
	}

}
