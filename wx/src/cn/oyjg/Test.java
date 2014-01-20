package cn.oyjg;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Test {
	public static void main(String[] args) {
		try{
			System.out.println(System.getProperty("java.library.path"));
//			Connection conn=getConn();
//			Statement stmt=conn.createStatement();
//			ResultSet rs=stmt.executeQuery("select * from nation order by id");
//			while(rs.next()){
//				//{ name: "Peter Pan", to: "peter@pan.de" },
//				System.out.println("{ids:\""+rs.getString("id")+"\",name:\""+rs.getString("Name").trim()+"\",fullcode:\""+rs.getString("fullcode").trim()+"\"},");
//			}
		}catch(Exception err){
			err.printStackTrace();
		}
		
		
//		String math = "x=\\frac{-b\\pm\\sqrt{b^2-4ac}}{2a}\\";
//
//		 TeXFormula fomule = new TeXFormula(math);
//		 //fomule.createJPEG(fomule.BOLD, 40, "d:\\f.jpg", Color.white, Color.black);
//		 Image img=fomule.createBufferedImage(math, fomule.BOLD, 40, Color.black, Color.white);
//		 BufferedImage bi = (BufferedImage) img;
//		 try {
//			FileOutputStream fos = new   FileOutputStream("d://img.jpg");
//			JPEGImageEncoder   encoder   =   JPEGCodec.createJPEGEncoder(fos);     
//		 	 encoder.encode(bi);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		   
		  
		 
		  
//		System.out.println(DateFormater.getDateFormat("yyyyMMddHHmm"));
		//createHtml();
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn=DriverManager.getConnection("jdbc:mysql://192.168.1.101:3306/xrba?useUnicode=true&characterEncoding=UTF-8","root","xinrui");
//			Statement stmt=conn.createStatement();
//			ResultSet rs=stmt.executeQuery("select * from user");
//			while(rs.next()){
//				System.out.println(rs.getString(1));
//			}
//			
//		}catch(Exception err){
//			err.printStackTrace();
//		}
	}
	public static void createHtml() {
		try {

			List list = getAllTableName();
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < list.size(); i++) {
				sb.append("<hr /><br />表名:" + list.get(i) + "<br />");
				sb.append("<table border=1>");
				sb
						.append("<tr style='background:gray' ><td width='200'>字段名</td><td width='200'>字段类型</td><td width='500'>注释</td></tr>");
				sb.append("<tr>");
				String sql = "SELECT COLUMN_NAME a, DATA_TYPE b,COLUMN_COMMENT c FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = '"
					+ list.get(i).toString().substring(0,list.get(i).toString().indexOf('(')) + "'";

				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					sb.append("<tr>");
					sb.append("<td>" + rs.getString("a") + "</td><td>"
							+ rs.getString("b") + "</td><td>"
							+ rs.getString("c") + "</td>");
					// System.out.println("字段名:"+rs.getString("a")+"
					// 字段类型:"+rs.getString("b")+" 注释:"+rs.getString("c"));
					sb.append("</tr>");
				}

				sb.append("</table>");
			}

			byte[] b = sb.toString().getBytes();
			FileOutputStream fis = new FileOutputStream(new File(
					"d:\\beian.html"));
			fis.write(sb.toString().getBytes(), 0, b.length);
			fis.flush();
			fis.close();

		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	public static List getAllTableName() throws Exception {

		List tables = new ArrayList();

		Connection conn = getConn();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT table_name t, TABLE_COMMENT zs FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = 'xrba'");

		while (rs.next()) {

			String tableName = rs.getString("t");
			
			tables.add(tableName+"("+rs.getString("zs")+")");

		}
		rs.close();

		stmt.close();

		conn.close();

		return tables;

	}
	public static Connection getConn(){
		Connection conn=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sms","sms");			
		}catch(Exception err){
			err.printStackTrace();
		}
		return conn;
	}
}