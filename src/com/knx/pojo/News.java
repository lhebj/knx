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

import com.knx.web.dto.NewsDTO;
import com.knx.web.dto.NewsSimpleDTO;
import com.knx.web.upload.UploadFileUtil;
import com.knx.web.util.DateUtil;

/**
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_news_n", catalog = "knxdb")
public class News implements java.io.Serializable {

	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 1873523699096231567L;
	private Long idN;
	private String titleN;
	private String contentN;
	private Content pic;
	private Date dateCreateN;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(Long idN, String titleN, String contentN,Content pic, Date dateCreateN) {
		this.idN = idN;
		this.titleN = titleN;
		this.contentN = contentN;
		this.pic = pic;
		this.dateCreateN = dateCreateN;
	}

	// Property accessors

	@Id
	@GeneratedValue
	@Column(name = "id_n", unique = true, nullable = false)
	public Long getIdN() {
		return this.idN;
	}

	public void setIdN(Long idN) {
		this.idN = idN;
	}

	@Column(name = "title_n", length = 256)
	public String getTitleN() {
		return this.titleN;
	}

	public void setTitleN(String titleN) {
		this.titleN = titleN;
	}

	@Column(name = "content_n", length = 65535)
	public String getContentN() {
		return this.contentN;
	}

	public void setContentN(String contentN) {
		this.contentN = contentN;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpic_n")
	public Content getPic() {
		return this.pic;
	}

	public void setPic(Content pic) {
		this.pic = pic;
	}

	@Column(name = "date_create_n", length = 19)
	public Date getDateCreateN() {
		return this.dateCreateN;
	}

	public void setDateCreateN(Date dateCreateN) {
		this.dateCreateN = dateCreateN;
	}
	
	public NewsDTO toDTO(){
		NewsDTO dto = new NewsDTO();
		dto.setIdN(idN);
		dto.setTitleN(titleN);
		dto.setContentN(contentN);
		if(getPic() != null){
			dto.setPic(UploadFileUtil.getContentPath(getPic()));
			dto.setPicName(this.getPic().getOriginalFilenameCon());
		}	
		dto.setDateCreateN(DateUtil.format(dateCreateN, DateUtil.DEFAULT_DATETIME_FORMAT));
		return dto;
	}
	
	public NewsSimpleDTO toSimpleDTO(){
		NewsSimpleDTO dto = new NewsSimpleDTO();
		dto.setIdN(idN);
		dto.setTitleN(titleN);
		return dto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof News))
			return false;
		News castOther = (News) other;

		return ((this.getIdN() == castOther.getIdN()) || (this.getIdN() != null && castOther.getIdN() != null && this.getIdN().equals(castOther.getIdN())))
				&& ((this.getTitleN() == castOther.getTitleN()) || (this.getTitleN() != null && castOther.getTitleN() != null && this.getTitleN().equals(castOther.getTitleN())))
				&& ((this.getContentN() == castOther.getContentN()) || (this.getContentN() != null && castOther.getContentN() != null && this.getContentN().equals(castOther.getContentN())))
				&& ((this.getDateCreateN() == castOther.getDateCreateN()) || (this.getDateCreateN() != null && castOther.getDateCreateN() != null && this.getDateCreateN().equals(castOther.getDateCreateN())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdN() == null ? 0 : this.getIdN().hashCode());
		result = 37 * result + (getTitleN() == null ? 0 : this.getTitleN().hashCode());
		result = 37 * result + (getContentN() == null ? 0 : this.getContentN().hashCode());
		result = 37 * result + (getDateCreateN() == null ? 0 : this.getDateCreateN().hashCode());
		return result;
	}

}