package cn.oyjg.system.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pt_user_use_log database table.
 * 
 */
@Entity
@Table(name="pt_user_use_log")
@NamedQuery(name="PtUserUseLog.findAll", query="SELECT p FROM PtUserUseLog p")
public class PtUserUseLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String ip;

	@Column(name="job_number")
	private String jobNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="USE_TIME")
	private Date useTime;

	@Column(name="USE_TYPE")
	private String useType;

	private int userid;

	private String username;

	public PtUserUseLog() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getJobNumber() {
		return this.jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public Date getUseTime() {
		return this.useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	public String getUseType() {
		return this.useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}