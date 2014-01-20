package cn.oyjg.system.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pt_role database table.
 * 
 */
@Entity
@Table(name="pt_role")
@NamedQuery(name="PtRole.findAll", query="SELECT p FROM PtRole p")
public class PtRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	private Date cttime;

	private int ctuser;

	private int deptid;

	private String descript;

	private int groupid;

	private String isdefault;

	private String isdel;

	private String name;

	private String state;

	@Temporal(TemporalType.TIMESTAMP)
	private Date udtime;

	private int uduser;

	public PtRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCttime() {
		return this.cttime;
	}

	public void setCttime(Date cttime) {
		this.cttime = cttime;
	}

	public int getCtuser() {
		return this.ctuser;
	}

	public void setCtuser(int ctuser) {
		this.ctuser = ctuser;
	}

	public int getDeptid() {
		return this.deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public int getGroupid() {
		return this.groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public String getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	public String getIsdel() {
		return this.isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getUduser() {
		return this.uduser;
	}

	public void setUduser(int uduser) {
		this.uduser = uduser;
	}

}