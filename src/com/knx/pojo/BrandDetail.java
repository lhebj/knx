package com.knx.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.knx.web.dto.BrandDetailDTO;
import com.knx.web.upload.UploadFileUtil;

/**
 * ProBrandDetailBrdd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_brand_detail_brdd", catalog = "knxdb")
public class BrandDetail implements java.io.Serializable {

	// Fields
	
	public static String FILE_LOGO = "logo";

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 5656377642089746457L;
	private Long idBrdd;
	private String introductionBrdd;	
	private Content logo;
	private Date dateCreateBrdd;
	private Brand brand;
	private Boolean isEnabledBrdd;
	

	// Constructors

	/** default constructor */
	public BrandDetail() {
	}

	/** full constructor */
	public BrandDetail(String introductionBrdd, Content logo, Date dateCreateBrdd, Brand brand, Boolean isEnabledBrdd) {
		this.introductionBrdd = introductionBrdd;
		this.logo = logo;
		this.dateCreateBrdd = dateCreateBrdd;
		this.brand = brand;
		this.isEnabledBrdd = isEnabledBrdd;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id_brdd", unique = true, nullable = false)
	public Long getIdBrdd() {
		return this.idBrdd;
	}

	public void setIdBrdd(Long idBrdd) {
		this.idBrdd = idBrdd;
	}

	@Column(name = "introduction_brdd", length = 65535)
	public String getIntroductionBrdd() {
		return this.introductionBrdd;
	}

	public void setIntroductionBrdd(String introductionBrdd) {
		this.introductionBrdd = introductionBrdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idlogo_brdd")
	public Content getLogo() {
		return this.logo;
	}

	public void setLogo(Content logo) {
		this.logo = logo;
	}

	
	@Column(name = "date_create_brdd")
	public Date getDateCreateBrdd() {
		return this.dateCreateBrdd;
	}

	public void setDateCreateBrdd(Date dateCreateBrdd) {
		this.dateCreateBrdd = dateCreateBrdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idbrd_brdd")  	
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(name = "is_enabled_brdd")
	public Boolean getIsEnabledBrdd() {
		return isEnabledBrdd;
	}

	public void setIsEnabledBrdd(Boolean isEnabledBrdd) {
		this.isEnabledBrdd = isEnabledBrdd;
	}

	public BrandDetailDTO toDTO(){
		BrandDetailDTO dto = new BrandDetailDTO();
		dto.setIntroductionBrdd(introductionBrdd);
		dto.setNameBrd(brand.getNameBrd());
		dto.setIdBrd(brand.getIdBrd());
		if(getLogo() != null){
			dto.setLogoPath(UploadFileUtil.getContentPath(getLogo()));
			dto.setLogoFileName(logo.getOriginalFilenameCon());
		}	
		return dto;
	}
	
}