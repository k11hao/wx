package cn.oyjg.base.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("DBHelp")
public class DBHelp {

	@Autowired
	@Qualifier("dataSource")
	private com.alibaba.druid.pool.DruidDataSource dataSource;

	public Connection getConn() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DBHelp获取连接失败");
			return null;
		}
	}

	public void close(Connection conn, Statement stmt, ResultSet rs){
		try{
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		}catch(Exception err){
			err.printStackTrace();
		}
	}
}
