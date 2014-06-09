package com.knx.pojo;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.knx.web.dto.CategoryDTO;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_category_cat", catalog = "knxdb")
public class Category implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -879131585560417052L;
	private Long idCat;
	private String nameCat;
	private String initialsCat;
	private Boolean isEnabledCat;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(Long idCat, String nameCat, String initialsCat, Boolean isEnabledCat) {
		this.idCat = idCat;
		this.nameCat = nameCat;
		this.initialsCat = initialsCat;
		this.isEnabledCat = isEnabledCat;
	}

	// Property accessors

	@Id
	@GeneratedValue
	@Column(name = "id_cat", unique = true, nullable = false)
	public Long getIdCat() {
		return this.idCat;
	}

	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}

	@Column(name = "name_cat", length = 128)
	public String getNameCat() {
		return this.nameCat;
	}

	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}

	@Column(name = "initials_cat", length = 1)
	public String getInitialsCat() {
		return this.initialsCat;
	}

	public void setInitialsCat(String initialsCat) {
		this.initialsCat = initialsCat;
	}
	
	public CategoryDTO toDTO(){
		CategoryDTO dto = new CategoryDTO();
		dto.setIdCat(idCat);
		dto.setNameCat(nameCat);
		dto.setInitialsCat(initialsCat);
		dto.setShow(true);
		return dto;
	}

	@Column(name = "is_enabled_cat")
	public Boolean getIsEnabledCat() {
		return isEnabledCat;
	}

	public void setIsEnabledCat(Boolean isEnabledCat) {
		this.isEnabledCat = isEnabledCat;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Category))
			return false;
		Category castOther = (Category) other;

		return ((this.getIdCat() == castOther.getIdCat()) || (this.getIdCat() != null && castOther.getIdCat() != null && this.getIdCat().equals(castOther.getIdCat())))
				&& ((this.getNameCat() == castOther.getNameCat()) || (this.getNameCat() != null && castOther.getNameCat() != null && this.getNameCat().equals(castOther.getNameCat())))
				&& ((this.getInitialsCat() == castOther.getInitialsCat()) || (this.getInitialsCat() != null && castOther.getInitialsCat() != null && this.getInitialsCat().equals(castOther.getInitialsCat())))
				&& ((this.getIsEnabledCat() == castOther.getIsEnabledCat()) || (this.getIsEnabledCat() != null && castOther.getIsEnabledCat() != null && this.getIsEnabledCat().equals(castOther.getIsEnabledCat())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdCat() == null ? 0 : this.getIdCat().hashCode());
		result = 37 * result + (getNameCat() == null ? 0 : this.getNameCat().hashCode());
		result = 37 * result + (getInitialsCat() == null ? 0 : this.getInitialsCat().hashCode());
		result = 37 * result + (getIsEnabledCat() == null ? 0 : this.getIsEnabledCat().hashCode());
		return result;
	}

}