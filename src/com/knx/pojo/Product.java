package com.knx.pojo;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.knx.web.dto.ProductDTO;
import com.knx.web.upload.UploadFileUtil;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_product_prd", catalog = "knxdb")
public class Product implements java.io.Serializable {

	// Fields
	public static String FILE_LOGO="logo";

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 7972167563372632720L;
	private Long idPrd;
	private String namePrd;
	private Brand brand;
	private Category category;
	private String modelPrd;
	private Content logo;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(Long idPrd, String namePrd, Brand brand, Category category, String modelPrd, Content logo) {
		this.idPrd = idPrd;
		this.namePrd = namePrd;
		this.brand = brand;
		this.category = category;
		this.modelPrd = modelPrd;
		this.logo = logo;
	}

	// Property accessors

	@Id
	@GeneratedValue
	@Column(name = "id_prd", unique = true, nullable = false)
	public Long getIdPrd() {
		return this.idPrd;
	}

	public void setIdPrd(Long idPrd) {
		this.idPrd = idPrd;
	}

	@Column(name = "name_prd", length = 256)
	public String getNamePrd() {
		return this.namePrd;
	}

	public void setNamePrd(String namePrd) {
		this.namePrd = namePrd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_brd_prd")
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cat_prd")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "model_prd", length = 128)
	public String getModelPrd() {
		return this.modelPrd;
	}

	public void setModelPrd(String modelPrd) {
		this.modelPrd = modelPrd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "logo_prd")
	public Content getLogo() {
		return this.logo;
	}

	public void setLogo(Content logo) {
		this.logo = logo;
	}
	
	public ProductDTO toDTO(){
		ProductDTO dto = new ProductDTO();
		dto.setIdPrd(idPrd);
		if(getLogo() != null){
			dto.setLogoPath(UploadFileUtil.getContentPath(getLogo()));
			dto.setLogoName(this.getLogo().getOriginalFilenameCon());
		}	
		dto.setModelPrd(modelPrd);
		dto.setNamePrd(namePrd);
		return dto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Product))
			return false;
		Product castOther = (Product) other;

		return ((this.getIdPrd() == castOther.getIdPrd()) || (this.getIdPrd() != null && castOther.getIdPrd() != null && this.getIdPrd().equals(castOther.getIdPrd())))
				&& ((this.getNamePrd() == castOther.getNamePrd()) || (this.getNamePrd() != null && castOther.getNamePrd() != null && this.getNamePrd().equals(castOther.getNamePrd())))
				&& ((this.getBrand() == castOther.getBrand()) || (this.getBrand() != null && castOther.getBrand() != null && this.getBrand().equals(castOther.getBrand())))
				&& ((this.getCategory() == castOther.getCategory()) || (this.getCategory() != null && castOther.getCategory() != null && this.getCategory().equals(castOther.getCategory())))
				&& ((this.getModelPrd() == castOther.getModelPrd()) || (this.getModelPrd() != null && castOther.getModelPrd() != null && this.getModelPrd().equals(castOther.getModelPrd())))
				&& ((this.getLogo() == castOther.getLogo()) || (this.getLogo() != null && castOther.getLogo() != null && this.getLogo().equals(castOther.getLogo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdPrd() == null ? 0 : this.getIdPrd().hashCode());
		result = 37 * result + (getNamePrd() == null ? 0 : this.getNamePrd().hashCode());
		result = 37 * result + (getBrand() == null ? 0 : this.getBrand().hashCode());
		result = 37 * result + (getCategory() == null ? 0 : this.getCategory().hashCode());
		result = 37 * result + (getModelPrd() == null ? 0 : this.getModelPrd().hashCode());
		result = 37 * result + (getLogo() == null ? 0 : this.getLogo().hashCode());
		return result;
	}

}