package cn.oyjg.system.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the pt_user_skin database table.
 * 
 */
@Entity
@Table(name="pt_user_skin")
@NamedQuery(name="PtUserSkin.findAll", query="SELECT p FROM PtUserSkin p")
public class PtUserSkin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;

	@Column(name="BK_FILEID")
	private BigInteger bkFileid;

	@Column(name="BK_PIC")
	private String bkPic;

	@Temporal(TemporalType.TIMESTAMP)
	private Date cttime;

	private int ctuser;

	@Column(name="DEFAULT_PAGE")
	private int defaultPage;

	@Column(name="HEAD_FILEID")
	private BigInteger headFileid;

	@Column(name="HEAD_PIC")
	private String headPic;

	@Column(name="MSG_SOUND")
	private String msgSound;

	@Column(name="TODO_HEIGHT")
	private int todoHeight;

	@Column(name="TODO_SOUND")
	private String todoSound;

	@Column(name="TODO_WIDTH")
	private int todoWidth;

	@Column(name="TODO_X")
	private int todoX;

	@Column(name="TODO_Y")
	private int todoY;

	@Temporal(TemporalType.TIMESTAMP)
	private Date udtime;

	private int uduser;

	@Column(name="USER_FACE")
	private String userFace;

	public PtUserSkin() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public BigInteger getBkFileid() {
		return this.bkFileid;
	}

	public void setBkFileid(BigInteger bkFileid) {
		this.bkFileid = bkFileid;
	}

	public String getBkPic() {
		return this.bkPic;
	}

	public void setBkPic(String bkPic) {
		this.bkPic = bkPic;
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

	public int getDefaultPage() {
		return this.defaultPage;
	}

	public void setDefaultPage(int defaultPage) {
		this.defaultPage = defaultPage;
	}

	public BigInteger getHeadFileid() {
		return this.headFileid;
	}

	public void setHeadFileid(BigInteger headFileid) {
		this.headFileid = headFileid;
	}

	public String getHeadPic() {
		return this.headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public String getMsgSound() {
		return this.msgSound;
	}

	public void setMsgSound(String msgSound) {
		this.msgSound = msgSound;
	}

	public int getTodoHeight() {
		return this.todoHeight;
	}

	public void setTodoHeight(int todoHeight) {
		this.todoHeight = todoHeight;
	}

	public String getTodoSound() {
		return this.todoSound;
	}

	public void setTodoSound(String todoSound) {
		this.todoSound = todoSound;
	}

	public int getTodoWidth() {
		return this.todoWidth;
	}

	public void setTodoWidth(int todoWidth) {
		this.todoWidth = todoWidth;
	}

	public int getTodoX() {
		return this.todoX;
	}

	public void setTodoX(int todoX) {
		this.todoX = todoX;
	}

	public int getTodoY() {
		return this.todoY;
	}

	public void setTodoY(int todoY) {
		this.todoY = todoY;
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

	public String getUserFace() {
		return this.userFace;
	}

	public void setUserFace(String userFace) {
		this.userFace = userFace;
	}

}