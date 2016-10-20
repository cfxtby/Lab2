package SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.book;

public class autherTable {
	private Connection con;
	private DbUtil d;
	public autherTable(DbUtil d){
		this.d=d;
		con=d.getCon();
	}
	
	public String getNewID(){
		String Order="SELECT * FROM author ORDER BY AuthorID DESC";
		Statement stmt;
		try {
			ArrayList<String> b=new ArrayList();
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			if(rs.next()){
	  			return ((Long)rs.getObject(1)+1)+"";
			}
			return "00000";
		} catch (SQLException e) {
			e.printStackTrace();
			return "000000";
		}
	}
	
    public ArrayList<String> FindID(String name){
  	  	String Order="SELECT * FROM author WHERE Name like '"+name+"'";
    	Statement stmt;
		try {
			ArrayList<String> b=new ArrayList();
			System.out.println(Order);
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			while(rs.next()){
	  			for (int i=1;i<=4;i++)
    	  			{
	  					if(i==1)b.add(rs.getObject(i)+"");
	  					else rs.getObject(i);
    	  			}
			}
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
	
	public boolean insert(String AuthorID,String Name,String age,String country){
		ArrayList<String> array=new ArrayList<String>();
		array.add(AuthorID);
		array.add(Name);
		array.add(age);
		array.add(country);
		int n=array.size();
		String Order="INSERT INTO author VALUES(";
		String tail=",";
		for(int i=0;i<n;i++){
			if(i==n-1)tail=")";
		if(array.get(i) instanceof String)
		  Order=Order+"'"+array.get(i)+"'"+tail;
			else Order=Order+array.get(i)+tail;
		}
		Statement stmt;
		try {
			stmt = con.createStatement();
			System.out.println(Order);
			stmt.executeUpdate(Order);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		 return true;
	}
    
    public ArrayList<String> Find(String id){
  	  	String Order="SELECT * FROM author WHERE AuthorID = "+id;
    	Statement stmt;
		try {
			ArrayList<String> b=new ArrayList();
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			if(rs.next()){
	  			for (int i=1;i<=4;i++)
    	  			{
	  					b.add(rs.getObject(i)+"");
    	  			}
			}
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public boolean exchange(String Age,String country,String id){
    	String order="UPDATE author SET Age="+Age+",Country="+country+
    			" WHERE AuthorID="+id;
		 Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(order);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			return false;
		}
		 return true;
    }
    
    
    public static void main(String args[]){
    	//autherTable at=new autherTable();
    	//at.insert("0110", "世界", "10", "中国");
    }
}
