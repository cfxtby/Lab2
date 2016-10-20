package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DbUtil {

	private PreparedStatement pstmt = null;

	private Connection con = null;

	/*
	 *
	 * 
	 * 
	 public DbUtil(){
	 	String driver = "com.mysql.jdbc.Driver";
		String username = System.getenv("ACCESSKEY");
		String password = System.getenv("SECRETKEY");
		//System.getenv("MYSQL_HOST_S"); 为从库，只读
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
		try {
		    Class.forName(driver).newInstance();
		    con = DriverManager.getConnection(dbUrl, username, password);
		    // ...
		} catch (Exception e) {
		    // ...
		}
		jzwelowxsfhj.rds.sae.sina.com.cn:10431
	}
	 * 
	 * */
	public DbUtil() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String username ="root"; //System.getenv("ACCESSKEY");
			String password = "tby1234";//System.getenv("SECRETKEY");
			//String dbUrl ="jdbc:mysql://jzwelowxsfhj.rds.sae.sina.com.cn:10431/bookdb?useUnicode=true&characterEncoding=UTF-8"; //String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), 
					//System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
			//Class.forName("com.mysql.jdbc.Driver");
			String dbUrl ="jdbc:mysql://jutpcjkobicj.rds.sae.sina.com.cn:10072"
					+ "/bookdb?useUnicode=true&characterEncoding=UTF-8"; 

			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	
	public Connection getCon() {
		return con;
	}

	public void close() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
 
	public static void main(String args[]){
		DbUtil d=new DbUtil();
		try {
			Statement stmt =d.getCon().createStatement();
			stmt.execute("Select * from Author ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

