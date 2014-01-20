package cn.oyjg.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.oyjg.base.dao.DBHelp;
import cn.oyjg.base.service.BaseService;
import cn.oyjg.base.util.PageUtil;
import cn.oyjg.system.model.PtFun;
import cn.oyjg.system.model.PtRole;
import cn.oyjg.system.model.PtUser;

@Service("ptUserService")
public class PtUserService extends BaseService<PtUser> {

	// @Cacheable(value="userCache")
	public List<PtUser> getAllUser(PageUtil page) {
		String hql = "from PtUser";
		return super.getDao().find(hql, page);
	}
   public List<PtUser> getPtUserlist(String name)
   {
	    String hql = "from PtUser where name=?";
		List<PtUser> list = dao.find(hql,name);
		return list;
   }
   public int updatePwd(String password,int id) throws Exception
   {
	   
	    String hql="update PtUser set password = ? where id =? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int r =0;
		try {
			conn = dbHelp.getConn();
			pstmt = conn.prepareStatement(hql);
			pstmt.setString(1,password);
			pstmt.setInt(2, id);
			r =pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelp.close(conn, pstmt, null);
		}
		return r;
   }
	public PtUser login(String username, String password) {
		// String hql = "from PtUser a left join Fetch a.roles r left join Fetch
		// r.PtFunes f left join  Fetch f.PtFunes f2 where a.loginName=?
		// and a.password=?";
		String hql = "from PtUser u where u.loginname=? and u.password=?";
		List<PtUser> list = dao.find(hql, username, password);
		if (list.size() > 0) {
			PtUser user=list.get(0);
			return user;
		} else {
			return null;
		}
	}

	public List<PtFun> getFunctionByRoleid(String roleid) {
		List<PtFun> list = null;		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			list = new ArrayList<PtFun>();		
			String sql="SELECT f.id,f.name,f.url,f.big_icon_path icon FROM Pt_Fun f LEFT JOIN pt_role_fun rf ON f.codes=rf.fun_code WHERE f.pid=0 AND rf.roleid in("+roleid+") and STATE=1 order by f.SHOW_SORT";
			conn = dbHelp.getConn();
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				PtFun f=new PtFun();				
				f.setId(rs.getInt("id"));
				f.setName(rs.getString("name"));
				f.setUrl(rs.getString("url"));
				f.setBigIconPath(rs.getString("icon"));
				list.add(f);
			}
			for(int i=0;i<list.size();i++){
				PtFun f=list.get(i);
				sql="SELECT f.id,f.name,f.url,f.big_icon_path icon FROM Pt_Fun f LEFT JOIN pt_role_fun rf ON f.codes=rf.fun_code WHERE f.pid="+f.getId()+" AND rf.roleid in ("+roleid+") and STATE=1 order by f.SHOW_SORT";
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					PtFun f2=new PtFun();
					f2.setId(rs.getInt("id"));
					f2.setName(rs.getString("name"));
					f2.setUrl(rs.getString("url"));
					f2.setBigIconPath(rs.getString("icon"));
					f.getPtFuns().add(f2);
				}
			}
			dbHelp.close(conn, stmt, rs);
			
		}catch(Exception err){
			err.printStackTrace();
		}
		
		return list;
	}

	// 根据用户获取资源地址列表
	public ArrayList<String> getFunctionURLlistByRoleid(int roleid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> funs = new ArrayList<String>();
		try {
			conn = dbHelp.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM roleid_PtFunid rf LEFT JOIN PtFun f ON rf.PtFunid=f.id  WHERE rf.roldid="+roleid+" AND url!=''");
			
			while (rs.next()) {
				funs.add(rs.getString("url"));
			}
			dbHelp.close(conn, stmt, rs);
		} catch (Exception err) {
			err.printStackTrace();
		}
		return funs;
	}
	

	/**
	 * 查询原密码是否配匹
	 * @param name
	 * @param pwd
	 * @return
	 */
	public int validatePwd(String name,String pwd)
	{
		String hql="select count(*) from PtUser where loginName=? and password =?";
		return Integer.parseInt(dao.find(hql,name,pwd).get(0).toString());
	}
	/**
	 * 修改密码
	 * @param num 
	 * @param name 
	 * 
	 * */
	public int editpwd(String password ,String name) throws Exception {
		String hql="update PtUser set password =? where login_Name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int r =0;
		try {
			conn = dbHelp.getConn();
			pstmt = conn.prepareStatement(hql);
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			r =pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbHelp.close(conn, pstmt, null);
		}
		return r;			
	}
	@Autowired
	@Qualifier("DBHelp")
	private DBHelp dbHelp;
}
