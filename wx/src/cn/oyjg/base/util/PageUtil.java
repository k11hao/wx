package cn.oyjg.base.util;

/**
 * 分页类
 * @author oyjg 
 * 
 */
public class PageUtil {
	//每页显示多少条记录
	private int pagesize = 10;
	//总页数
	private int pageTotal = 0;
	//当前第几页
	private int pageindex=1;
	//总记录数
	private int recordTotal = 0;
	//查询时是否分页
	private boolean isPage=true;

	public boolean isPage() {
		return isPage;
	}

	public void setIsPage(boolean isPage) {
		this.isPage = isPage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public int getPageTotal() {
		if (this.getRecordTotal() % this.getPagesize() == 0) {
			return this.getRecordTotal() / this.getPagesize();
		} else {
			return this.getRecordTotal() / this.getPagesize() + 1;
		}
	}
	
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}


	public int getRecordTotal() {
		return recordTotal;
	}

	public void setRecordTotal(int recordTotal) {
		this.recordTotal = recordTotal;
		this.setPageTotal(this.getPageTotal());
	}

	public int getPageindex() {
		return pageindex;
	}

	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

}
