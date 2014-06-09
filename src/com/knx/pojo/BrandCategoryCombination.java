package com.knx.pojo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Brand entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_brand_category_bc", catalog = "knxdb")
public class BrandCategoryCombination implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -6830309925526383474L;
	private Long idBc;
	private Brand brand;
	private Category category;
	
	// Constructors

	/** default constructor */
	public BrandCategoryCombination() {
	}

	/** full constructor */
	public BrandCategoryCombination(Long idBc, Brand brand, Category category) {
		this.idBc = idBc;
		this.brand = brand;
		this.category = category;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_bc", unique = true, nullable = false)
	public Long getIdBc() {
		return idBc;
	}

	public void setIdBc(Long idBc) {
		this.idBc = idBc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_brd_bc")
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cat_bc")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
