package cn.oyjg.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected ModelMap map;
	
	@ModelAttribute
	public void init(HttpServletRequest request,HttpServletResponse response,HttpSession session,ModelMap map){
		this.request=request;
		this.response=response;
		this.session=session;
		this.map=map;
	}
}
