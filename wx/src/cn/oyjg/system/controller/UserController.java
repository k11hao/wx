package cn.oyjg.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.oyjg.base.constants.Constants;
import cn.oyjg.base.constants.ResultFlag;
import cn.oyjg.base.controller.BaseController;
import cn.oyjg.base.util.PageUtil;
import cn.oyjg.system.model.PtFun;
import cn.oyjg.system.model.PtUser;
import cn.oyjg.system.service.PtRoleService;
import cn.oyjg.system.service.PtUserService;

/**
 * 
 * @author 阳建国
 * 
 */
@Controller
public class UserController extends BaseController {

private static final Logger log = Logger.getLogger(UserController.class);  
	
	
	//用户管理
	@RequestMapping(value="sys_userList")
	public String userList(PageUtil page){
		List<PtUser> ulst=userService.getAllUser(page);
		map.put("ulst", ulst);
		map.put("page", page);
		return "/sys/userMgr";
	}
	@RequestMapping(value="user_login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="user_login", method=RequestMethod.POST)
	@ResponseBody
	public ResultFlag login(String loginname,String pwd){
		ResultFlag rf=new ResultFlag();
		PtUser user=userService.login(loginname, pwd);
		if(user==null){
			rf.setFlag(false);
			rf.setMsg("用户名或密码错误");
		}else{
			session.setAttribute(Constants.userInfo, user);
			//查询所属角色
			String roleids=ptRoleService.getRoles(user.getUserid());
			user.setRoles(roleids);
			rf.setFlag(true);
		}		
		return rf;
	}
	@RequestMapping(value="toindex",method=RequestMethod.GET)
	public String toindex(){
		//查询用户功能
		PtUser user=(PtUser)session.getAttribute(Constants.userInfo);
		List<PtFun> pftlst=userService.getFunctionByRoleid(user.getRoles());
		map.put("flst", pftlst);
		return "index2";
	}
	
	@Resource(name="ptUserService")
	private PtUserService userService;
	
	@Resource(name="ptRoleService")
	private PtRoleService ptRoleService;
}