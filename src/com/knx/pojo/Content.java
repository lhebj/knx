package com.knx.pojo;

// default package

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Content entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_content_con", catalog = "knxdb")
public class Content implements java.io.Serializable {

	public static String SRC_CON_INDEX = "index";
	public static String SRC_CON_NEWS = "news";
	public static String SRC_CON_BRAND = "brand";
	public static String SRC_CON_PRODUCT = "product";
	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 6282469667587443746L;
	private Long idCon;
	private String originalFilenameCon;
	private String filenameCon;
	private Long filesizeCon;
	private String mimetypeCon;
	private String encodingCon;
	private String filepathCon;
	private Date dateCreateCon;
	private String srcCon;

	// Constructors

	/** default constructor */
	public Content() {
	}

	/** full constructor */
	public Content(Long idCon, String originalFilenameCon, String filenameCon, Long filesizeCon, String mimetypeCon, String encodingCon, String filepathCon, Date dateCreateCon, String srcCon) {
		this.idCon = idCon;
		this.originalFilenameCon = originalFilenameCon;
		this.filenameCon = filenameCon;
		this.filesizeCon = filesizeCon;
		this.mimetypeCon = mimetypeCon;
		this.encodingCon = encodingCon;
		this.filepathCon = filepathCon;
		this.dateCreateCon = dateCreateCon;
		this.srcCon = srcCon;
	}

	// Property accessors

	@Id
	@GeneratedValue
	@Column(name = "id_con", unique = true, nullable = false)
	public Long getIdCon() {
		return this.idCon;
	}

	public void setIdCon(Long idCon) {
		this.idCon = idCon;
	}

	@Column(name = "original_filename_con", length = 128)
	public String getOriginalFilenameCon() {
		return this.originalFilenameCon;
	}

	public void setOriginalFilenameCon(String originalFilenameCon) {
		this.originalFilenameCon = originalFilenameCon;
	}

	@Column(name = "filename_con", length = 128)
	public String getFilenameCon() {
		return this.filenameCon;
	}

	public void setFilenameCon(String filenameCon) {
		this.filenameCon = filenameCon;
	}

	@Column(name = "filesize_con")
	public Long getFilesizeCon() {
		return this.filesizeCon;
	}

	public void setFilesizeCon(Long filesizeCon) {
		this.filesizeCon = filesizeCon;
	}

	@Column(name = "mimetype_con", length = 32)
	public String getMimetypeCon() {
		return this.mimetypeCon;
	}

	public void setMimetypeCon(String mimetypeCon) {
		this.mimetypeCon = mimetypeCon;
	}

	@Column(name = "encoding_con", length = 16)
	public String getEncodingCon() {
		return this.encodingCon;
	}

	public void setEncodingCon(String encodingCon) {
		this.encodingCon = encodingCon;
	}

	@Column(name = "filepath_con", length = 256)
	public String getFilepathCon() {
		return this.filepathCon;
	}

	public void setFilepathCon(String filepathCon) {
		this.filepathCon = filepathCon;
	}

	@Column(name = "date_create_con", length = 19)
	public Date getDateCreateCon() {
		return this.dateCreateCon;
	}

	public void setDateCreateCon(Date dateCreateCon) {
		this.dateCreateCon = dateCreateCon;
	}

	@Column(name = "src_con", length = 32)
	public String getSrcCon() {
		return this.srcCon;
	}

	public void setSrcCon(String srcCon) {
		this.srcCon = srcCon;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Content))
			return false;
		Content castOther = (Content) other;

		return ((this.getIdCon() == castOther.getIdCon()) || (this.getIdCon() != null && castOther.getIdCon() != null && this.getIdCon().equals(castOther.getIdCon())))
				&& ((this.getOriginalFilenameCon() == castOther.getOriginalFilenameCon()) || (this.getOriginalFilenameCon() != null && castOther.getOriginalFilenameCon() != null && this.getOriginalFilenameCon().equals(castOther.getOriginalFilenameCon())))
				&& ((this.getFilenameCon() == castOther.getFilenameCon()) || (this.getFilenameCon() != null && castOther.getFilenameCon() != null && this.getFilenameCon().equals(castOther.getFilenameCon())))
				&& ((this.getFilesizeCon() == castOther.getFilesizeCon()) || (this.getFilesizeCon() != null && castOther.getFilesizeCon() != null && this.getFilesizeCon().equals(castOther.getFilesizeCon())))
				&& ((this.getMimetypeCon() == castOther.getMimetypeCon()) || (this.getMimetypeCon() != null && castOther.getMimetypeCon() != null && this.getMimetypeCon().equals(castOther.getMimetypeCon())))
				&& ((this.getEncodingCon() == castOther.getEncodingCon()) || (this.getEncodingCon() != null && castOther.getEncodingCon() != null && this.getEncodingCon().equals(castOther.getEncodingCon())))
				&& ((this.getFilepathCon() == castOther.getFilepathCon()) || (this.getFilepathCon() != null && castOther.getFilepathCon() != null && this.getFilepathCon().equals(castOther.getFilepathCon())))
				&& ((this.getDateCreateCon() == castOther.getDateCreateCon()) || (this.getDateCreateCon() != null && castOther.getDateCreateCon() != null && this.getDateCreateCon().equals(castOther.getDateCreateCon())))
				&& ((this.getSrcCon() == castOther.getSrcCon()) || (this.getSrcCon() != null && castOther.getSrcCon() != null && this.getSrcCon().equals(castOther.getSrcCon())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdCon() == null ? 0 : this.getIdCon().hashCode());
		result = 37 * result + (getOriginalFilenameCon() == null ? 0 : this.getOriginalFilenameCon().hashCode());
		result = 37 * result + (getFilenameCon() == null ? 0 : this.getFilenameCon().hashCode());
		result = 37 * result + (getFilesizeCon() == null ? 0 : this.getFilesizeCon().hashCode());
		result = 37 * result + (getMimetypeCon() == null ? 0 : this.getMimetypeCon().hashCode());
		result = 37 * result + (getEncodingCon() == null ? 0 : this.getEncodingCon().hashCode());
		result = 37 * result + (getFilepathCon() == null ? 0 : this.getFilepathCon().hashCode());
		result = 37 * result + (getDateCreateCon() == null ? 0 : this.getDateCreateCon().hashCode());
		result = 37 * result + (getSrcCon() == null ? 0 : this.getSrcCon().hashCode());
		return result;
	}
}