package cn.oyjg.system.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pt_user database table.
 * 
 */
@Entity
@Table(name="pt_user")
@NamedQuery(name="PtUser.findAll", query="SELECT p FROM PtUser p")
public class PtUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userid;

	private String addr;

	private String birthday;

	@Column(name="CARD_NUMBER")
	private String cardNumber;

	private String cttime;

	private Integer ctuser;

	private Integer deptid;

	private String email;

	@Column(name="IDENTITY_CARD")
	private String identityCard;

	@Column(name="JOB_NUMBER")
	private String jobNumber;

	private String loginname;

	private String mobile;

	private String password;

	private String phone;

	private String pki;

	@Column(name="POSITION_ID")
	private Integer positionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PWDEND_TIME")
	private Date pwdendTime;

	private String sex;

	private String state;

	@Temporal(TemporalType.TIMESTAMP)
	private Date udtime;

	private Integer uduser;

	private String usbkey;

	@Column(name="USER_TYPE")
	private Integer userType;

	private String username;

	@Column(name="ZIP_CODE")
	private String zipCode;

	
	/**
	 * 角色列表
	 * 字符拼接角色ID
	 */
	@Transient
	private String roles;
	
	public String getRoles() {
		return roles;
	}
	
	public void setRoles(String roles) {
		this.roles = roles;
	}

	
	public PtUser() {
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCttime() {
		return this.cttime;
	}

	public void setCttime(String cttime) {
		this.cttime = cttime;
	}

	public Integer getCtuser() {
		return this.ctuser;
	}

	public void setCtuser(Integer ctuser) {
		this.ctuser = ctuser;
	}

	public Integer getDeptid() {
		return this.deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentityCard() {
		return this.identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getJobNumber() {
		return this.jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPki() {
		return this.pki;
	}

	public void setPki(String pki) {
		this.pki = pki;
	}

	public Integer getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Date getPwdendTime() {
		return this.pwdendTime;
	}

	public void setPwdendTime(Date pwdendTime) {
		this.pwdendTime = pwdendTime;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getUdtime() {
		return this.udtime;
	}

	public void setUdtime(Date udtime) {
		this.udtime = udtime;
	}

	public Integer getUduser() {
		return this.uduser;
	}

	public void setUduser(Integer uduser) {
		this.uduser = uduser;
	}

	public String getUsbkey() {
		return this.usbkey;
	}

	public void setUsbkey(String usbkey) {
		this.usbkey = usbkey;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}