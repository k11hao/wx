package cn.oyjg.base.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 编码
 * @author Administrator
 *
 */
public class CharacterEncodingFilter implements Filter {
	private String encoding="UTF-8";
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		
	      
		
		// TODO Auto-generated method stub
		if (encoding != null) {
			// 对请求进行编码设置
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
			response.setContentType("text/html; charset="+encoding+"");
		}else{
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
		}
		// 将处理权转交给下一个处理器
		
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
	    response.setHeader("Expires","0");//禁止缓存 
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.encoding = config.getInitParameter("encoding");
	}

}
