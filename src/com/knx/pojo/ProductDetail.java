package com.knx.pojo;

// default package

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.knx.web.dto.ProductDetailDTO;
import com.knx.web.upload.UploadFileUtil;
import com.knx.web.util.DateUtil;

/**
 * ProductDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_product_detail_prdd", catalog = "knxdb")
public class ProductDetail implements java.io.Serializable {
	
	public static String FILE_BIG_PIC= "big_pic";
	public static String FILE_SMALL_PIC_1= "small_pic_1";
	public static String FILE_SMALL_PIC_2= "small_pic_2";
	public static String FILE_SMALL_PIC_3= "small_pic_3";
	public static String FILE_SMALL_PIC_4= "small_pic_4";
	public static String FILE_SMALL_PIC_5= "small_pic_5";
	public static String FILE_SMALL_PIC_6= "small_pic_6";
	public static String FILE_DETAIL_LOGO= "detail_logo";

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -3212923487507311143L;
	private Long idPrdd;
	private Product product;
	private String placePrdd;
	private String introductionPrdd;
	private String parametersPrdd;
	private String featuresPrdd;
	private String supplierPrdd;
	private Content idbigpicPrdd;
	private Content idsmallpic1Prdd;
	private Content idsmallpic2Prdd;
	private Content idsmallpic3Prdd;
	private Content idsmallpic4Prdd;
	private Content idsmallpic5Prdd;
	private Content idsmallpic6Prdd;
	private Content iddetaillogoPrdd;
	private Date dateCreatePrdd;

	// Constructors

	/** default constructor */
	public ProductDetail() {
	}

	/** full constructor */
	public ProductDetail(Long idPrdd, Product product, String placePrd, String introductionPrdd, String parametersPrdd, String featuresPrdd, String supplierPrdd, Content idbigpicPrdd, Content idsmallpic1Prdd, Content idsmallpic2Prdd, Content idsmallpic3Prdd, Content idsmallpic4Prdd,
			Content idsmallpic5Prdd, Content idsmallpic6Prdd, Content iddetaillogoPrdd, Date dateCreatePrdd) {
		this.idPrdd = idPrdd;
		this.product = product;
		this.placePrdd = placePrd;
		this.introductionPrdd = introductionPrdd;
		this.parametersPrdd = parametersPrdd;
		this.featuresPrdd = featuresPrdd;
		this.supplierPrdd = supplierPrdd;
		this.idbigpicPrdd = idbigpicPrdd;
		this.idsmallpic1Prdd = idsmallpic1Prdd;
		this.idsmallpic2Prdd = idsmallpic2Prdd;
		this.idsmallpic3Prdd = idsmallpic3Prdd;
		this.idsmallpic4Prdd = idsmallpic4Prdd;
		this.idsmallpic5Prdd = idsmallpic5Prdd;
		this.idsmallpic6Prdd = idsmallpic6Prdd;
		this.iddetaillogoPrdd = iddetaillogoPrdd;
		this.dateCreatePrdd = dateCreatePrdd;
	}

	// Property accessors

	@Id
	@GeneratedValue
	@Column(name = "id_prdd", unique = true, nullable = false)
	public Long getIdPrdd() {
		return this.idPrdd;
	}

	public void setIdPrdd(Long idPrdd) {
		this.idPrdd = idPrdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idprd_prdd")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "place_prdd", length = 128)
	public String getPlacePrdd() {
		return this.placePrdd;
	}

	public void setPlacePrdd(String placePrdd) {
		this.placePrdd = placePrdd;
	}

	@Column(name = "introduction_prdd", length = 65535)
	public String getIntroductionPrdd() {
		return this.introductionPrdd;
	}

	public void setIntroductionPrdd(String introductionPrdd) {
		this.introductionPrdd = introductionPrdd;
	}

	@Column(name = "parameters_prdd", length = 65535)
	public String getParametersPrdd() {
		return this.parametersPrdd;
	}

	public void setParametersPrdd(String parametersPrdd) {
		this.parametersPrdd = parametersPrdd;
	}

	@Column(name = "features_prdd", length = 65535)
	public String getFeaturesPrdd() {
		return this.featuresPrdd;
	}

	public void setFeaturesPrdd(String featuresPrdd) {
		this.featuresPrdd = featuresPrdd;
	}

	@Column(name = "supplier_prdd", length = 512)
	public String getSupplierPrdd() {
		return this.supplierPrdd;
	}

	public void setSupplierPrdd(String supplierPrdd) {
		this.supplierPrdd = supplierPrdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idbigpic_prdd")
	public Content getIdbigpicPrdd() {
		return this.idbigpicPrdd;
	}

	public void setIdbigpicPrdd(Content idbigpicPrdd) {
		this.idbigpicPrdd = idbigpicPrdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsmallpic1_prdd")
	public Content getIdsmallpic1Prdd() {
		return this.idsmallpic1Prdd;
	}

	public void setIdsmallpic1Prdd(Content idsmallpic1Prdd) {
		this.idsmallpic1Prdd = idsmallpic1Prdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsmallpic2_prdd")
	public Content getIdsmallpic2Prdd() {
		return this.idsmallpic2Prdd;
	}

	public void setIdsmallpic2Prdd(Content idsmallpic2Prdd) {
		this.idsmallpic2Prdd = idsmallpic2Prdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsmallpic3_prdd")
	public Content getIdsmallpic3Prdd() {
		return this.idsmallpic3Prdd;
	}

	public void setIdsmallpic3Prdd(Content idsmallpic3Prdd) {
		this.idsmallpic3Prdd = idsmallpic3Prdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsmallpic4_prdd")
	public Content getIdsmallpic4Prdd() {
		return this.idsmallpic4Prdd;
	}

	public void setIdsmallpic4Prdd(Content idsmallpic4Prdd) {
		this.idsmallpic4Prdd = idsmallpic4Prdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsmallpic5_prdd")
	public Content getIdsmallpic5Prdd() {
		return this.idsmallpic5Prdd;
	}

	public void setIdsmallpic5Prdd(Content idsmallpic5Prdd) {
		this.idsmallpic5Prdd = idsmallpic5Prdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsmallpic6_prdd")
	public Content getIdsmallpic6Prdd() {
		return this.idsmallpic6Prdd;
	}

	public void setIdsmallpic6Prdd(Content idsmallpic6Prdd) {
		this.idsmallpic6Prdd = idsmallpic6Prdd;
	}

	@Column(name = "date_create_prdd", length = 19)
	public Date getDateCreatePrdd() {
		return this.dateCreatePrdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddetaillogo_prdd")
	public Content getIddetaillogoPrdd() {
		return iddetaillogoPrdd;
	}

	public void setIddetaillogoPrdd(Content iddetaillogoPrdd) {
		this.iddetaillogoPrdd = iddetaillogoPrdd;
	}

	public void setDateCreatePrdd(Date dateCreatePrdd) {
		this.dateCreatePrdd = dateCreatePrdd;
	}
	
	public ProductDetailDTO toDTO(){
		ProductDetailDTO dto = new ProductDetailDTO();
		dto.setIdPrdd(idPrdd);
		dto.setProductDTO(product.toDTO());
		dto.setBrandDTO(product.getBrand().toDTO());
		dto.setCategoryDTO(product.getCategory().toDTO());
		dto.setFeaturesPrdd(featuresPrdd);
		dto.setDateCreatePrdd(DateUtil.format(dateCreatePrdd, DateUtil.DEFAULT_DATETIME_FORMAT));
		if(this.getIdbigpicPrdd() != null){
			dto.setIdbigpicPrdd(UploadFileUtil.getContentPath(getIdbigpicPrdd()));
			dto.setIdbigpicNamePrdd(this.idbigpicPrdd.getOriginalFilenameCon());
		}
		if(this.getIdsmallpic1Prdd() != null){
			dto.setIdsmallpic1Prdd(UploadFileUtil.getContentPath(getIdsmallpic1Prdd()));
			dto.setIdsmallpic1NamePrdd(this.idsmallpic1Prdd.getOriginalFilenameCon());
		}	
		if(this.getIdsmallpic2Prdd() != null){
			dto.setIdsmallpic2Prdd(UploadFileUtil.getContentPath(getIdsmallpic2Prdd()));
			dto.setIdsmallpic2NamePrdd(this.getIdsmallpic2Prdd().getOriginalFilenameCon());
		}
		if(this.getIdsmallpic3Prdd() != null){
			dto.setIdsmallpic3Prdd(UploadFileUtil.getContentPath(getIdsmallpic3Prdd()));
			dto.setIdsmallpic3NamePrdd(this.getIdsmallpic3Prdd().getOriginalFilenameCon());
		}
		if(this.getIdsmallpic4Prdd() != null){
			dto.setIdsmallpic4Prdd(UploadFileUtil.getContentPath(getIdsmallpic4Prdd()));
			dto.setIdsmallpic4NamePrdd(this.getIdsmallpic4Prdd().getOriginalFilenameCon());
		}
		if(this.getIdsmallpic5Prdd() != null){
			dto.setIdsmallpic5Prdd(UploadFileUtil.getContentPath(getIdsmallpic5Prdd()));
			dto.setIdsmallpic5NamePrdd(this.getIdsmallpic5Prdd().getOriginalFilenameCon());
		}
		if(this.getIdsmallpic6Prdd() != null){
			dto.setIdsmallpic6Prdd(UploadFileUtil.getContentPath(getIdsmallpic6Prdd()));
			dto.setIdsmallpic6NamePrdd(this.getIdsmallpic6Prdd().getOriginalFilenameCon());
		}
		if(this.getIddetaillogoPrdd() != null){
			dto.setIddetaillogoNamePrdd(this.getIddetaillogoPrdd().getOriginalFilenameCon());
			dto.setIddetaillogoPrdd(UploadFileUtil.getContentPath(this.getIddetaillogoPrdd()));
		}
		dto.setIntroductionPrdd(introductionPrdd);
		dto.setParametersPrdd(parametersPrdd);
		dto.setPlacePrdd(placePrdd);
		dto.setProductDTO(product.toDTO());
		dto.setSupplierPrdd(supplierPrdd);
		return dto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductDetail))
			return false;
		ProductDetail castOther = (ProductDetail) other;

		return ((this.getIdPrdd() == castOther.getIdPrdd()) || (this.getIdPrdd() != null && castOther.getIdPrdd() != null && this.getIdPrdd().equals(castOther.getIdPrdd())))
				&& ((this.getProduct() == castOther.getProduct()) || (this.getProduct() != null && castOther.getProduct() != null && this.getProduct().equals(castOther.getProduct())))
				&& ((this.getPlacePrdd() == castOther.getPlacePrdd()) || (this.getPlacePrdd() != null && castOther.getPlacePrdd() != null && this.getPlacePrdd().equals(castOther.getPlacePrdd())))
				&& ((this.getIntroductionPrdd() == castOther.getIntroductionPrdd()) || (this.getIntroductionPrdd() != null && castOther.getIntroductionPrdd() != null && this.getIntroductionPrdd().equals(castOther.getIntroductionPrdd())))
				&& ((this.getParametersPrdd() == castOther.getParametersPrdd()) || (this.getParametersPrdd() != null && castOther.getParametersPrdd() != null && this.getParametersPrdd().equals(castOther.getParametersPrdd())))
				&& ((this.getFeaturesPrdd() == castOther.getFeaturesPrdd()) || (this.getFeaturesPrdd() != null && castOther.getFeaturesPrdd() != null && this.getFeaturesPrdd().equals(castOther.getFeaturesPrdd())))
				&& ((this.getSupplierPrdd() == castOther.getSupplierPrdd()) || (this.getSupplierPrdd() != null && castOther.getSupplierPrdd() != null && this.getSupplierPrdd().equals(castOther.getSupplierPrdd())))
				&& ((this.getIdbigpicPrdd() == castOther.getIdbigpicPrdd()) || (this.getIdbigpicPrdd() != null && castOther.getIdbigpicPrdd() != null && this.getIdbigpicPrdd().equals(castOther.getIdbigpicPrdd())))
				&& ((this.getIdsmallpic1Prdd() == castOther.getIdsmallpic1Prdd()) || (this.getIdsmallpic1Prdd() != null && castOther.getIdsmallpic1Prdd() != null && this.getIdsmallpic1Prdd().equals(castOther.getIdsmallpic1Prdd())))
				&& ((this.getIdsmallpic2Prdd() == castOther.getIdsmallpic2Prdd()) || (this.getIdsmallpic2Prdd() != null && castOther.getIdsmallpic2Prdd() != null && this.getIdsmallpic2Prdd().equals(castOther.getIdsmallpic2Prdd())))
				&& ((this.getIdsmallpic3Prdd() == castOther.getIdsmallpic3Prdd()) || (this.getIdsmallpic3Prdd() != null && castOther.getIdsmallpic3Prdd() != null && this.getIdsmallpic3Prdd().equals(castOther.getIdsmallpic3Prdd())))
				&& ((this.getIdsmallpic4Prdd() == castOther.getIdsmallpic4Prdd()) || (this.getIdsmallpic4Prdd() != null && castOther.getIdsmallpic4Prdd() != null && this.getIdsmallpic4Prdd().equals(castOther.getIdsmallpic4Prdd())))
				&& ((this.getIdsmallpic5Prdd() == castOther.getIdsmallpic5Prdd()) || (this.getIdsmallpic5Prdd() != null && castOther.getIdsmallpic5Prdd() != null && this.getIdsmallpic5Prdd().equals(castOther.getIdsmallpic5Prdd())))
				&& ((this.getIdsmallpic6Prdd() == castOther.getIdsmallpic6Prdd()) || (this.getIdsmallpic6Prdd() != null && castOther.getIdsmallpic6Prdd() != null && this.getIdsmallpic6Prdd().equals(castOther.getIdsmallpic6Prdd())))
				&& ((this.getDateCreatePrdd() == castOther.getDateCreatePrdd()) || (this.getDateCreatePrdd() != null && castOther.getDateCreatePrdd() != null && this.getDateCreatePrdd().equals(castOther.getDateCreatePrdd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdPrdd() == null ? 0 : this.getIdPrdd().hashCode());
		result = 37 * result + (getProduct() == null ? 0 : this.getProduct().hashCode());
		result = 37 * result + (getPlacePrdd() == null ? 0 : this.getPlacePrdd().hashCode());
		result = 37 * result + (getIntroductionPrdd() == null ? 0 : this.getIntroductionPrdd().hashCode());
		result = 37 * result + (getParametersPrdd() == null ? 0 : this.getParametersPrdd().hashCode());
		result = 37 * result + (getFeaturesPrdd() == null ? 0 : this.getFeaturesPrdd().hashCode());
		result = 37 * result + (getSupplierPrdd() == null ? 0 : this.getSupplierPrdd().hashCode());
		result = 37 * result + (getIdbigpicPrdd() == null ? 0 : this.getIdbigpicPrdd().hashCode());
		result = 37 * result + (getIdsmallpic1Prdd() == null ? 0 : this.getIdsmallpic1Prdd().hashCode());
		result = 37 * result + (getIdsmallpic2Prdd() == null ? 0 : this.getIdsmallpic2Prdd().hashCode());
		result = 37 * result + (getIdsmallpic3Prdd() == null ? 0 : this.getIdsmallpic3Prdd().hashCode());
		result = 37 * result + (getIdsmallpic4Prdd() == null ? 0 : this.getIdsmallpic4Prdd().hashCode());
		result = 37 * result + (getIdsmallpic5Prdd() == null ? 0 : this.getIdsmallpic5Prdd().hashCode());
		result = 37 * result + (getIdsmallpic6Prdd() == null ? 0 : this.getIdsmallpic6Prdd().hashCode());
		result = 37 * result + (getDateCreatePrdd() == null ? 0 : this.getDateCreatePrdd().hashCode());
		return result;
	}

}