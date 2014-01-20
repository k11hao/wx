package cn.oyjg.system.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the pt_fun database table.
 * 
 */
@Entity
@Table(name="pt_fun")
@NamedQuery(name="PtFun.findAll", query="SELECT p FROM PtFun p")
public class PtFun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="BIG_ICON_PATH")
	private String bigIconPath;

	private String codes;

	@Temporal(TemporalType.TIMESTAMP)
	private Date cttime;

	private int ctuser;

	private String descript;
	
	@Column(name="postion")
	private String postion;
	

	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name="ISCLIENT_SUP")
	private String isclientSup;

	private String isshow;

	private String istray;

	private String name;
	
	@Transient
	private List<PtFun> ptFuns=new ArrayList<PtFun>();
	

	public List<PtFun> getPtFuns() {
		return ptFuns;
	}

	public void setPtFuns(List<PtFun> ptFuns) {
		this.ptFuns = ptFuns;
	}

	@Column(name="NAME_ABV")
	private String nameAbv;

	private int pid;

	@Column(name="SHOW_SORT")
	private int showSort;

	@Column(name="SM_ICON_ID")
	private BigInteger smIconId;

	@Column(name="SM_ICON_PATH")
	private String smIconPath;

	private String state;

	@Temporal(TemporalType.TIMESTAMP)
	private Date udtime;

	private int uduser;

	private String url;

	public PtFun() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBigIconPath() {
		return this.bigIconPath;
	}

	public void setBigIconPath(String bigIconPath) {
		this.bigIconPath = bigIconPath;
	}

	public String getCodes() {
		return this.codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
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

	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getIsclientSup() {
		return this.isclientSup;
	}

	public void setIsclientSup(String isclientSup) {
		this.isclientSup = isclientSup;
	}

	public String getIsshow() {
		return this.isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public String getIstray() {
		return this.istray;
	}

	public void setIstray(String istray) {
		this.istray = istray;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameAbv() {
		return this.nameAbv;
	}

	public void setNameAbv(String nameAbv) {
		this.nameAbv = nameAbv;
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getShowSort() {
		return this.showSort;
	}

	public void setShowSort(int showSort) {
		this.showSort = showSort;
	}

	public BigInteger getSmIconId() {
		return this.smIconId;
	}

	public void setSmIconId(BigInteger smIconId) {
		this.smIconId = smIconId;
	}

	public String getSmIconPath() {
		return this.smIconPath;
	}

	public void setSmIconPath(String smIconPath) {
		this.smIconPath = smIconPath;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}