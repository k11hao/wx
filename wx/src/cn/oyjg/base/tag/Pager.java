package cn.oyjg.base.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import cn.oyjg.base.util.PageUtil;
/**
 * 分页tag
 * @author 阳建国
 *
 */
public class Pager extends BodyTagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url; // 地址
	String callback; // 执行javaScript回调函数
	String formid;//搜索表单ID

	String css=""; // 自定义样式
	int pageindex; // 当前页
	int pageSize; // 一页显示条数
	int recordTotal; // 总条数 
	int pageTotal; // 总页数
	

	@Override
	public int doEndTag() throws JspException {
		//String basePath=pageContext.getRequest().getScheme()+"://"+pageContext.getRequest().getServerName()+":"+pageContext.getRequest().getServerPort()+pageContext.getServletContext().getContextPath()+"/";
		JspWriter out = pageContext.getOut();
		//初始化分页类
		PageUtil p=(PageUtil)pageContext.getRequest().getAttribute("page");
		if(p==null){
			return super.EVAL_PAGE;
		}
		pageindex=p.getPageindex();
		pageSize=p.getPagesize();
		recordTotal=p.getRecordTotal();
		pageTotal=p.getPageTotal();
		//页数不能为零，如果没有数据为零时，自动将总页数的当前页设为1
//		if(pageindex==0){
//			pageindex=1;
//			pageTotal=1;
//		}
		StringBuffer sb = new StringBuffer();
		//根据有没有回调函数(callback)判断是否ajax无刷新分页
		if (this.callback == null) {

			sb.append("<div class='"+css+"' id='pager11'>共"+recordTotal+"条记录&nbsp;当前页" + pageindex + "/" + pageTotal);
			sb.append("&nbsp;每页显示<select onchange='go()' id='pageSize' name='pagesize' >" +
					"<option value='10'>10</option><option value='20'>20</option><option value='30'>30</option><option value='40'>40</option><option value='50'>50</option></select>" +
					"<script>$('#pageSize').val('"+pageSize+"');</script>");
			sb.append("&nbsp;&nbsp;<input  type='button' value='首页' onclick=\"$('#pageindex').val(1);go()\" >");
			
			if (pageindex > 1) {
				sb.append("&nbsp;<input  type='button' value='上一页' onclick=\"$('#pageindex').val("+(pageindex-1)+");go()\" >");
			} else {
				sb.append("&nbsp;<input  type='button' value='上一页' disabled >");
			}

			sb.append("&nbsp;跳转到&nbsp;<input   type='text' size='4' value='"
					+ pageindex + "' onchange=\"$('#pageindex').val(this.value);go()\" />&nbsp;页");

			if (this.getPageTotal() > pageindex) {
				sb.append("&nbsp;<input  type='button' value='下一页' onclick=\"$('#pageindex').val("+(pageindex+1)+");go()\" >");
			} else {
				sb.append("&nbsp;<input  type='button' value='下一页' disabled >");
			}
			sb.append("&nbsp;<input  type='button' value='尾页' onclick=\"$('#pageindex').val("+pageTotal+");go()\" >");
			sb.append("<input type='hidden' id='pageindex' name='pageindex' value='"+pageindex+"' >");
			sb.append("<script>function go(){document.forms[0].submit()};</script></div>");
			//判断当前页是否大于最大页数否则跳到第最后一页
			if(pageindex>pageTotal){
				//当没有数据的时候,currentPage为1pageTotal为0会,所以排除
				if(pageTotal!=0)
				sb.append("<script>$('#pageindex').val("+pageTotal+");go()</script>");
			}			
		}else{

			if(null ==formid || formid.equals("")){
				formid="form";
			}
			sb.append("<script>" +
					"function "+formid+"Go(){" +
					"$.ajax({"+
				"url : $('#"+formid+"').attr('action'),"+
				"type : 'post',"+
				"data : $('#"+formid+"').serialize(),"+
				"success : function(data1){" +
				"ps=$('#"+formid+" #pageSize').val();$('#"+formid+" #HidData').html(data1);" +					//将新数据加入到隐藏div中
				"$('#"+formid+" #pager11').html($('#"+formid+" #HidData #pager11').html());" +	//更新当前页显示信息
				"var newdata=($('#"+formid+" #HidData #data').html());"+callback+"(newdata);" +
				"$('#"+formid+" #HidData').html('');$('#"+formid+" #pageSize').val(ps);},error:function(){"+callback+"('error')}" +
				"});" +
						"}</script>");
			
			sb.append("<div id='pager11'>共"+recordTotal+"条记录&nbsp;当前页 " + pageindex + "/" + pageTotal+"");
			sb.append("&nbsp;每页显示<select name='pagesize' onchange=\"" +
					"iserr="+recordTotal+"%this.value==0?parseInt("+recordTotal+"/this.value):parseInt("+recordTotal+"/this.value+1);" +
					"if(iserr<$('#"+formid+" #pageindex').val()){$('#"+formid+" #pageindex').val(iserr);}" +
					formid+"Go()\" id='pageSize' ><option value='10'>10</option><option value='20'>20</option><option value='30'>30</option><option value='40'>40</option><option value='50'>50</option></select>" +
					"");
			if(pageindex==1){
				sb.append("&nbsp;<input  type='button' value='首 页' disabled />");
			}else{
				sb.append("&nbsp;<input  type='button' value='首 页' onclick=\"$('#"+formid+" #pageindex').val(1);"+formid+"Go()\" />");
			}
			if (pageindex > 1) {
					sb.append("&nbsp;<input  type='button' value='上一页' onclick=\"$('#"+formid+" #pageindex').val("+(pageindex-1)+");"+formid+"Go()\"  />");
				} else {
					sb.append("&nbsp;<input  type='button' value='上一页' disabled />");
				}

				sb.append("&nbsp;跳转到&nbsp;<input onchange=\"$('#"+formid+" #pageindex').val(this.value);"+formid+"Go()\" onKeyUp=\"this.value=this.value.replace(/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(/\\D/g,'')\" id='pageN' type='text' size='4' value='"
						+ pageindex + "' />&nbsp;页");
				if (this.getPageTotal() > pageindex) {
					sb.append("&nbsp;<input  type='button' value='下一页' onclick=\"$('#"+formid+" #pageindex').val("+(pageindex+1)+");"+formid+"Go()\" />");
				} else {
					sb.append("&nbsp;<input  type='button' value='下一页' disabled />");
				}
				if(pageindex==pageTotal){
					sb.append("&nbsp;<input  type='button' value='尾 页' disabled />");
				}else{
					sb.append("&nbsp;<input  type='button' value='尾 页' onclick=\"$('#"+formid+" #pageindex').val("+pageTotal+");"+formid+"Go()\" />");
				}
				sb.append("<input type='hidden' id='pageindex' name='pageindex' value='"+pageindex+"' >"
						+ "</div>");
				sb.append("<div style='background:red;display:none' id='HidData'>.</div></div>");
				

				//判断当前页是否大于最大页数否则跳到第最后一页
				if(pageindex>pageTotal){
					//当没有数据的时候,currentPage为1pageTotal为0会,所以排除
					if(pageTotal!=0)
					sb.append("<script>$('#"+formid+" #pageindex').val("+pageTotal+");"+formid+"Go()</script>");
				}
		}
		try {
			out.print(sb.toString());
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.EVAL_PAGE;
	}

	
	public int getPageindex() {
		return pageindex;
	}


	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordTotal() {
		return recordTotal;
	}

	public void setRecordTotal(int recordTotal) {
		this.recordTotal = recordTotal;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}


	public String getFormid() {
		return formid;
	}


	public void setFormid(String formid) {
		this.formid = formid;
	}
	
	
}
