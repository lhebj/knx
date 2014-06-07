package com.knx.pojo;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.knx.web.dto.BrandDTO;

/**
 * Brand entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_brand_brd", catalog = "knxdb")
public class Brand implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -6830309925526383474L;
	private Long idBrd;
	private String nameBrd;
	private String initialsBrd;
	private Boolean isEnabledBrd;

	// Constructors

	/** default constructor */
	public Brand() {
	}

	/** full constructor */
	public Brand(Long idBrd, String nameBrd, String initialsBrd, Boolean isEnabledBrd) {
		this.idBrd = idBrd;
		this.nameBrd = nameBrd;
		this.initialsBrd = initialsBrd;
		this.isEnabledBrd = isEnabledBrd;
	}

	// Property accessors

	@Id
	@GeneratedValue
	@Column(name = "id_brd", unique = true, nullable = false)
	public Long getIdBrd() {
		return this.idBrd;
	}

	public void setIdBrd(Long idBrd) {
		this.idBrd = idBrd;
	}

	@Column(name = "name_brd", length = 128)
	public String getNameBrd() {
		return this.nameBrd;
	}

	public void setNameBrd(String nameBrd) {
		this.nameBrd = nameBrd;
	}

	@Column(name = "initials_brd", length = 1)
	public String getInitialsBrd() {
		return this.initialsBrd;
	}

	public void setInitialsBrd(String initialsBrd) {
		this.initialsBrd = initialsBrd;
	}
	

	@Column(name = "is_enabled_brd")
	public Boolean getIsEnabledBrd() {
		return this.isEnabledBrd;
	}

	public void setIsEnabledBrd(Boolean isEnabledBrd) {
		this.isEnabledBrd = isEnabledBrd;
	}
	
	public BrandDTO toDTO(){
		BrandDTO dto = new BrandDTO();
		dto.setIdBrd(idBrd);
		dto.setNameBrd(nameBrd);
		dto.setInitialsBrd(initialsBrd);
		return dto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Brand))
			return false;
		Brand castOther = (Brand) other;

		return ((this.getIdBrd() == castOther.getIdBrd()) || (this.getIdBrd() != null && castOther.getIdBrd() != null && this.getIdBrd().equals(castOther.getIdBrd())))
				&& ((this.getNameBrd() == castOther.getNameBrd()) || (this.getNameBrd() != null && castOther.getNameBrd() != null && this.getNameBrd().equals(castOther.getNameBrd())))
				&& ((this.getInitialsBrd() == castOther.getInitialsBrd()) || (this.getInitialsBrd() != null && castOther.getInitialsBrd() != null && this.getInitialsBrd().equals(castOther.getInitialsBrd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdBrd() == null ? 0 : this.getIdBrd().hashCode());
		result = 37 * result + (getNameBrd() == null ? 0 : this.getNameBrd().hashCode());
		result = 37 * result + (getInitialsBrd() == null ? 0 : this.getInitialsBrd().hashCode());
		result = 37 * result + (getIsEnabledBrd() == null ? 0 : this.getIsEnabledBrd().hashCode());
		return result;
	}

}