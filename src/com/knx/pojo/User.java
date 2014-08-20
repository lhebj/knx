package com.knx.pojo;

// default package

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.knx.web.dto.UserDTO;
import com.knx.web.util.DateUtil;
import com.knx.web.util.StringUtil;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knx_user_u", catalog = "knxdb", uniqueConstraints = @UniqueConstraint(columnNames = "username_u"))
public class User implements java.io.Serializable {

	public static String ADMIN = "admin";
	// Fields

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 9005984585621971061L;
	private Long idU;
	private String usernameU;
	private String passwordU;
	private String saltU;
	private String emailU;
	private String weixinU;
	private Date dateRegisterU;
	private String ipU;
	private String refererU;
	private Boolean isEnabledU;
	private String backupInfo;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Long idU, String usernameU, String passwordU, String saltU, String emailU, String weixinU, Date dateRegisterU, String ipU, String refererU, Boolean isEnabledU, String backupInfo) {
		this.idU = idU;
		this.usernameU = usernameU;
		this.passwordU = passwordU;
		this.saltU = saltU;
		this.emailU = emailU;
		this.weixinU = weixinU;
		this.dateRegisterU = dateRegisterU;
		this.ipU = ipU;
		this.refererU = refererU;
		this.isEnabledU = isEnabledU;
		this.backupInfo = backupInfo;
	}

	// Property accessors

	@Id
	@GeneratedValue
	@Column(name = "id_u", unique = true, nullable = false)
	public Long getIdU() {
		return this.idU;
	}

	public void setIdU(Long idU) {
		this.idU = idU;
	}

	@Column(name = "username_u", length = 64)
	public String getUsernameU() {
		return this.usernameU;
	}

	public void setUsernameU(String usernameU) {
		this.usernameU = usernameU;
	}

	@Column(name = "password_u", length = 64)
	public String getPasswordU() {
		return this.passwordU;
	}

	public void setPasswordU(String passwordU) {
		this.passwordU = passwordU;
	}

	@Column(name = "salt_u", length = 64)
	public String getSaltU() {
		return saltU;
	}

	public void setSaltU(String saltU) {
		this.saltU = saltU;
	}

	@Column(name = "email_u", length = 128)
	public String getEmailU() {
		return this.emailU;
	}

	public void setEmailU(String emailU) {
		this.emailU = emailU;
	}

	@Column(name = "weixin_u", length = 64)
	public String getWeixinU() {
		return this.weixinU;
	}

	public void setWeixinU(String weixinU) {
		this.weixinU = weixinU;
	}

	@Column(name = "date_register_u", length = 19)
	public Date getDateRegisterU() {
		return this.dateRegisterU;
	}

	public void setDateRegisterU(Date dateRegisterU) {
		this.dateRegisterU = dateRegisterU;
	}

	@Column(name = "ip_u", length = 16)
	public String getIpU() {
		return this.ipU;
	}

	public void setIpU(String ipU) {
		this.ipU = ipU;
	}

	@Column(name = "referer_u", length = 512)
	public String getRefererU() {
		return this.refererU;
	}

	public void setRefererU(String refererU) {
		this.refererU = refererU;
	}

	@Column(name = "is_enabled_u")
	public Boolean getIsEnabledU() {
		return this.isEnabledU;
	}

	public void setIsEnabledU(Boolean isEnabledU) {
		this.isEnabledU = isEnabledU;
	}
	
	@Column(name = "backup_info_u", length = 128)
	public String getBackupInfo() {
		return backupInfo;
	}

	public void setBackupInfo(String backupInfo) {
		this.backupInfo = backupInfo;
	}

	public UserDTO toDTO(){
		UserDTO dto = new UserDTO();
		dto.setIdU(idU);
		dto.setIpU(ipU);
		dto.setEmailU(emailU);
		dto.setIsEnabledU(isEnabledU);
		dto.setRefererU(refererU);
		dto.setUsernameU(usernameU);
		dto.setWeixinU(weixinU);
		dto.setDateRegisterU(DateUtil.format(dateRegisterU, DateUtil.DEFAULT_DATETIME_FORMAT));
		return dto;
	}

	
	public static String generateSalt(){
		String salt = StringUtil.getRandomString(4);
		
		return salt;
	}
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof User))
			return false;
		User castOther = (User) other;

		return ((this.getIdU() == castOther.getIdU()) || (this.getIdU() != null && castOther.getIdU() != null && this.getIdU().equals(castOther.getIdU())))
				&& ((this.getUsernameU() == castOther.getUsernameU()) || (this.getUsernameU() != null && castOther.getUsernameU() != null && this.getUsernameU().equals(castOther.getUsernameU())))
				&& ((this.getPasswordU() == castOther.getPasswordU()) || (this.getPasswordU() != null && castOther.getPasswordU() != null && this.getPasswordU().equals(castOther.getPasswordU())))
				&& ((this.getEmailU() == castOther.getEmailU()) || (this.getEmailU() != null && castOther.getEmailU() != null && this.getEmailU().equals(castOther.getEmailU())))
				&& ((this.getWeixinU() == castOther.getWeixinU()) || (this.getWeixinU() != null && castOther.getWeixinU() != null && this.getWeixinU().equals(castOther.getWeixinU())))
				&& ((this.getDateRegisterU() == castOther.getDateRegisterU()) || (this.getDateRegisterU() != null && castOther.getDateRegisterU() != null && this.getDateRegisterU().equals(castOther.getDateRegisterU())))
				&& ((this.getIpU() == castOther.getIpU()) || (this.getIpU() != null && castOther.getIpU() != null && this.getIpU().equals(castOther.getIpU())))
				&& ((this.getRefererU() == castOther.getRefererU()) || (this.getRefererU() != null && castOther.getRefererU() != null && this.getRefererU().equals(castOther.getRefererU())))
				&& ((this.getIsEnabledU() == castOther.getIsEnabledU()) || (this.getIsEnabledU() != null && castOther.getIsEnabledU() != null && this.getIsEnabledU().equals(castOther.getIsEnabledU())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdU() == null ? 0 : this.getIdU().hashCode());
		result = 37 * result + (getUsernameU() == null ? 0 : this.getUsernameU().hashCode());
		result = 37 * result + (getPasswordU() == null ? 0 : this.getPasswordU().hashCode());
		result = 37 * result + (getEmailU() == null ? 0 : this.getEmailU().hashCode());
		result = 37 * result + (getWeixinU() == null ? 0 : this.getWeixinU().hashCode());
		result = 37 * result + (getDateRegisterU() == null ? 0 : this.getDateRegisterU().hashCode());
		result = 37 * result + (getIpU() == null ? 0 : this.getIpU().hashCode());
		result = 37 * result + (getRefererU() == null ? 0 : this.getRefererU().hashCode());
		result = 37 * result + (getIsEnabledU() == null ? 0 : this.getIsEnabledU().hashCode());
		return result;
	}
}