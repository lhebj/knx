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

import com.knx.web.dto.ProductDownloadDTO;
import com.knx.web.util.DateUtil;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_product_download_prdl", catalog = "knxdb")
public class ProductDownload implements java.io.Serializable {
	public static final String NAME_PRE = "namePrdl";
	public static final String FILE_PRE = "dlFile";
	public static final int MAX_UPLOADFILES = 20;
	
	/**
	 * TODO
	 */
	private static final long serialVersionUID = -3339873434450414228L;
	private Long idPrdl;
	private Product product;
	private String namePrdl;
	private Content filePrdl;
	private Date dateCreatePrdl;

	// Constructors

	/** default constructor */
	public ProductDownload() {
	}

	/** full constructor */
	public ProductDownload(Long idPrdl,Product product, String namePrdl, Content filePrdl, Date dateCreatePrdl) {
		this.idPrdl = idPrdl;
		this.product = product;
		this.namePrdl = namePrdl;
		this.filePrdl = filePrdl;
		this.dateCreatePrdl = dateCreatePrdl;
	}

	@Id
	@GeneratedValue
	@Column(name = "id_prdl", unique = true, nullable = false)
	public Long getIdPrdl() {
		return idPrdl;
	}

	public void setIdPrdl(Long idPrdl) {
		this.idPrdl = idPrdl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prd_prdl")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "name_prdl", length = 256)
	public String getNamePrdl() {
		return namePrdl;
	}

	public void setNamePrdl(String namePrdl) {
		this.namePrdl = namePrdl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_file_prdl")
	public Content getFilePrdl() {
		return filePrdl;
	}

	public void setFilePrdl(Content filePrdl) {
		this.filePrdl = filePrdl;
	}

	@Column(name = "date_create_prdl", length = 19)
	public Date getDateCreatePrdl() {
		return dateCreatePrdl;
	}

	public void setDateCreatePrdl(Date dateCreatePrdl) {
		this.dateCreatePrdl = dateCreatePrdl;
	}
	
	public ProductDownloadDTO toDTO(){
		ProductDownloadDTO dto = new ProductDownloadDTO();
		dto.setIdPrdl(idPrdl);
		dto.setNamePrdl(namePrdl);
		if(filePrdl != null){
			dto.setFileNamePrdl(filePrdl.getOriginalFilenameCon());
//			dto.setFilePathPrdl(UploadFileUtil.getContentPath(getFilePrdl()));
		}
		dto.setDateCreatePrdl(DateUtil.format(dateCreatePrdl, DateUtil.DEFAULT_DATETIME_FORMAT));
		
		return dto;
	}
}
