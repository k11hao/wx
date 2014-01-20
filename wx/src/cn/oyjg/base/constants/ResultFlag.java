package cn.oyjg.base.constants;

public class ResultFlag {
	private boolean flag;
	private String msg;
	private Object data;
	
	public ResultFlag(){
	}
	
	public ResultFlag(boolean flag) {
		super();
		this.flag = flag;
	}
	
	public ResultFlag(boolean flag, String msg) {
		super();
		this.flag = flag;
		this.msg = msg;
	}
	
	public ResultFlag(boolean flag, String msg, Object data) {
		super();
		this.flag = flag;
		this.msg = msg;
		this.data = data;
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
