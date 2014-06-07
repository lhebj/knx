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

import com.knx.web.dto.IndexDTO;
import com.knx.web.upload.UploadFileUtil;

/**
 * Index entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_index_idx", catalog = "knxdb")
public class Index implements java.io.Serializable {

	public static String TYPE_PIC = "pic";
	public static String TYPE_VIDEO = "video";
	
	public static String POSITION_R1C1 = "r1c1";
	public static String POSITION_R1C2 = "r1c2";
	public static String POSITION_R1C3 = "r1c3";
	public static String POSITION_R2C1 = "r2c1";
	public static String POSITION_R2C2 = "r2c2";
	public static String POSITION_R2C3 = "r2c3";
	
	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 972799692553647558L;
	private Long idIdx;
	private Content pic;
	private String typeIdx;
	private String playcodeIdx;
	private String positionIdx;
	private String linkIdx;
	private Date dateCreateIdx;

	// Constructors

	/** default constructor */
	public Index() {
	}

	/** full constructor */
	public Index(Long idIdx, Content pic, String typeIdx, String playcodeIdx, String positionIdx, String linkIdx, Date dateCreateIdx) {
		this.idIdx = idIdx;
		this.pic = pic;
		this.typeIdx = typeIdx;
		this.playcodeIdx = playcodeIdx;
		this.positionIdx = positionIdx;
		this.linkIdx = linkIdx;
		this.dateCreateIdx = dateCreateIdx;
	}

	// Property accessors

	@Id
	@GeneratedValue
	@Column(name = "id_idx", unique = true, nullable = false)
	public Long getIdIdx() {
		return this.idIdx;
	}

	public void setIdIdx(Long idIdx) {
		this.idIdx = idIdx;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpic_idx")
	public Content getPic() {
		return this.pic;
	}

	public void setPic(Content pic) {
		this.pic = pic;
	}

	@Column(name = "type_idx", length = 160)
	public String getTypeIdx() {
		return this.typeIdx;
	}

	public void setTypeIdx(String typeIdx) {
		this.typeIdx = typeIdx;
	}

	@Column(name = "playcode_idx", length = 1024)
	public String getPlaycodeIdx() {
		return this.playcodeIdx;
	}

	public void setPlaycodeIdx(String playcodeIdx) {
		this.playcodeIdx = playcodeIdx;
	}

	@Column(name = "position_idx", length = 8)
	public String getPositionIdx() {
		return positionIdx;
	}

	public void setPositionIdx(String positionIdx) {
		this.positionIdx = positionIdx;
	}

	@Column(name = "link_idx", length = 256)
	public String getLinkIdx() {
		return linkIdx;
	}

	public void setLinkIdx(String linkIdx) {
		this.linkIdx = linkIdx;
	}

	@Column(name = "date_create_idx", length = 19)
	public Date getDateCreateIdx() {
		return this.dateCreateIdx;
	}

	public void setDateCreateIdx(Date dateCreateIdx) {
		this.dateCreateIdx = dateCreateIdx;
	}

	public IndexDTO toDTO(){
		IndexDTO dto = new IndexDTO();
		dto.setIdIdx(idIdx);
		if(this.getPic() != null){
			dto.setPath(UploadFileUtil.getContentPath(getPic()));
		}		
		dto.setTypeIdx(typeIdx);
		dto.setPlaycodeIdx(playcodeIdx);
		dto.setPositionIdx(positionIdx);
		dto.setLinkIdx(linkIdx);
		return dto;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Index))
			return false;
		Index castOther = (Index) other;

		return ((this.getIdIdx() == castOther.getIdIdx()) || (this.getIdIdx() != null && castOther.getIdIdx() != null && this.getIdIdx().equals(castOther.getIdIdx())))
				&& ((this.getPic() == castOther.getPic()) || (this.getPic() != null && castOther.getPic() != null && this.getPic().equals(castOther.getPic())))
				&& ((this.getTypeIdx() == castOther.getTypeIdx()) || (this.getTypeIdx() != null && castOther.getTypeIdx() != null && this.getTypeIdx().equals(castOther.getTypeIdx())))
				&& ((this.getPlaycodeIdx() == castOther.getPlaycodeIdx()) || (this.getPlaycodeIdx() != null && castOther.getPlaycodeIdx() != null && this.getPlaycodeIdx().equals(castOther.getPlaycodeIdx())))
				&& ((this.getDateCreateIdx() == castOther.getDateCreateIdx()) || (this.getDateCreateIdx() != null && castOther.getDateCreateIdx() != null && this.getDateCreateIdx().equals(castOther.getDateCreateIdx())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdIdx() == null ? 0 : this.getIdIdx().hashCode());
		result = 37 * result + (getPic() == null ? 0 : this.getPic().hashCode());
		result = 37 * result + (getTypeIdx() == null ? 0 : this.getTypeIdx().hashCode());
		result = 37 * result + (getPlaycodeIdx() == null ? 0 : this.getPlaycodeIdx().hashCode());
		result = 37 * result + (getDateCreateIdx() == null ? 0 : this.getDateCreateIdx().hashCode());
		return result;
	}

}