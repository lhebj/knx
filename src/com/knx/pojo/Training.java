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

import com.knx.web.dto.TrainingDTO;
import com.knx.web.dto.TrainingSimpleDTO;
import com.knx.web.upload.UploadFileUtil;
import com.knx.web.util.DateUtil;

/**
 * Training entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_training_tra", catalog = "knxdb")
public class Training implements java.io.Serializable {
	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -687944848605844025L;
	private Long idTra;
	private String titleTra;
	private String contentTra;
	private Content pic;
	private Date dateCreateTra;

	// Constructors

	/** default constructor */
	public Training() {
	}

	/** full constructor */
	public Training(Long idTra, String titleTra, String contentTra,Content pic, Date dateCreateTra) {
		this.idTra = idTra;
		this.titleTra = titleTra;
		this.contentTra = contentTra;
		this.pic =pic;
		this.dateCreateTra = dateCreateTra;
	}

	// Property accessors

	@Id
	@GeneratedValue
	@Column(name = "id_tra", unique = true, nullable = false)
	public Long getIdTra() {
		return this.idTra;
	}

	public void setIdTra(Long idTra) {
		this.idTra = idTra;
	}

	@Column(name = "title_tra", length = 256)
	public String getTitleTra() {
		return this.titleTra;
	}

	public void setTitleTra(String titleTra) {
		this.titleTra = titleTra;
	}

	@Column(name = "content_tra", length = 65535)
	public String getContentTra() {
		return this.contentTra;
	}

	public void setContentTra(String contentTra) {
		this.contentTra = contentTra;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpic_tra")
	public Content getPic() {
		return this.pic;
	}

	public void setPic(Content pic) {
		this.pic = pic;
	}


	@Column(name = "date_create_tra", length = 19)
	public Date getDateCreateTra() {
		return this.dateCreateTra;
	}

	public void setDateCreateTra(Date dateCreateTra) {
		this.dateCreateTra = dateCreateTra;
	}
	
	public TrainingDTO toDTO(){
		TrainingDTO dto = new TrainingDTO();
		dto.setIdTra(idTra);
		dto.setTitleTra(titleTra);
		dto.setContentTra(contentTra);
		if(getPic() != null){
			dto.setPic(UploadFileUtil.getContentPath(getPic()));
			dto.setPicName(this.getPic().getOriginalFilenameCon());
		}	
		dto.setDateCreateTra(DateUtil.format(dateCreateTra, DateUtil.DEFAULT_DATETIME_FORMAT));
		return dto;
	}
	
	public TrainingSimpleDTO toSimpleDTO(){
		TrainingSimpleDTO dto = new TrainingSimpleDTO();
		dto.setIdTra(idTra);
		dto.setTitleTra(titleTra);
		return dto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Training))
			return false;
		Training castOther = (Training) other;

		return ((this.getIdTra() == castOther.getIdTra()) || (this.getIdTra() != null && castOther.getIdTra() != null && this.getIdTra().equals(castOther.getIdTra())))
				&& ((this.getTitleTra() == castOther.getTitleTra()) || (this.getTitleTra() != null && castOther.getTitleTra() != null && this.getTitleTra().equals(castOther.getTitleTra())))
				&& ((this.getContentTra() == castOther.getContentTra()) || (this.getContentTra() != null && castOther.getContentTra() != null && this.getContentTra().equals(castOther.getContentTra())))
				&& ((this.getDateCreateTra() == castOther.getDateCreateTra()) || (this.getDateCreateTra() != null && castOther.getDateCreateTra() != null && this.getDateCreateTra().equals(castOther.getDateCreateTra())))
				&& ((this.getPic() == castOther.getPic()) || (this.getPic() != null && castOther.getPic() != null && this.getPic().equals(castOther.getPic())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdTra() == null ? 0 : this.getIdTra().hashCode());
		result = 37 * result + (getTitleTra() == null ? 0 : this.getTitleTra().hashCode());
		result = 37 * result + (getContentTra() == null ? 0 : this.getContentTra().hashCode());
		result = 37 * result + (getPic() == null ? 0 : this.getPic().hashCode());
		result = 37 * result + (getDateCreateTra() == null ? 0 : this.getDateCreateTra().hashCode());
		return result;
	}
}