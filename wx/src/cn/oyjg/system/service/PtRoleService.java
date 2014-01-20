package cn.oyjg.system.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.oyjg.base.dao.DBHelp;
import cn.oyjg.base.service.BaseService;
import cn.oyjg.system.model.PtFun;
import cn.oyjg.system.model.PtRole;

@Service("ptRoleService")
public class PtRoleService extends BaseService<PtRole>{
	public List<PtRole> getAllRoles(){
		String hql="from Roles";
		List<PtRole> roles=dao.find(hql);
		return roles;
	}
	
	/**
	 * 根据用户ID获取角色ID
	 * @return
	 */
	public String getRoles(Integer userid){
		String roleid="";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{		
			String sql="select roleid from pt_user_role where userid="+userid;
			conn = dbHelp.getConn();
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				roleid+=rs.getString("roleid")+",";
			}
			roleid=roleid.substring(0,roleid.length()-1);
		}catch(Exception err){
			err.printStackTrace();
		}finally{
			dbHelp.close(conn, stmt, rs);
		}
		return roleid;
	}
	
	@Autowired
	@Qualifier("DBHelp")
	private DBHelp dbHelp;
}
