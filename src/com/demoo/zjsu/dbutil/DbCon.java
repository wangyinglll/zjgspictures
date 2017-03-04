/**
 * @author yuanjian
 * @time 2015-07-12
 * @function 鏁版嵁搴撹繛鎺�
*/
package com.demoo.zjsu.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbCon {
	
	private static ResourceBundle rb;
	private static String DBDRIVER = "";
	private static String DBURL = "";
	private static String DBUSER = "";
	private static String DBPASS = "";
	private static Connection con = null;
	
	public static Connection Con() {
	
		try {
			rb = ResourceBundle.getBundle("value");
			DBUSER = rb.getString("username");
			DBPASS = rb.getString("password");
			DBDRIVER = rb.getString("DBDRIVER");
			DBURL = rb.getString("DBURL");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			Class.forName(DBDRIVER);// System.out.println("driver succesful");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("driver fails1");
		}
		try {
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);// System.out.println("successful connect");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("SQL Server fail");
		}
		return con;
	}
	/**
	 * 返回链接accesstoken库的
	 * @return
	 */
	public static Connection Con_Accesstoken() {
		
		try {
			rb = ResourceBundle.getBundle("value");
			DBUSER = rb.getString("username");
			DBPASS = rb.getString("password");
			DBDRIVER = rb.getString("DBDRIVER");
			DBURL = rb.getString("DBURL_accesstoken");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			Class.forName(DBDRIVER);// System.out.println("driver succesful");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("driver fails1");
		}
		try {
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);// System.out.println("successful connect");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("SQL Server fail");
		}
		return con;
	}
	/**
	 * 关闭连接池
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void destroyDb(Connection conn, PreparedStatement ps, ResultSet rs){
		try {
			if(conn != null){
				conn.close();
			}if(ps != null){
				ps.close();
			}if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
		}
	}
}
