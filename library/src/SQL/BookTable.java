package SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.book;

public class BookTable {
	private Connection con;
	private DbUtil d;
	public BookTable(DbUtil d){
		this.d=d;
		con=d.getCon();
	}

	public String getNewID(){
		String Order="SELECT * FROM book ORDER BY isbn DESC";
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
	
   public boolean Insert(ArrayList array){
	  	 int n=array.size();
	  	 String Order="INSERT INTO book VALUES(";
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
		
	public boolean Delete(String id){
		 String Order="DELETE FROM book WHERE ISBN="+id;
		 Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(Order);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			return false;
		}
		 return true;
	  }
	

    public ArrayList<String> get(String id){
    	ArrayList<String> a=new ArrayList();
    	String Order="SELECT * FROM book WHERE ISBN = "+id;
    	Statement stmt;
		try {
			ArrayList<book> b=new ArrayList();
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			if(rs.next()){
	  			for (int i=1;i<=6;i++)
    	  			{
	  					a.add(rs.getObject(i)+"");
    	  			}
    	  		return a;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    public ArrayList<book> Find(String id,String name){
  	  	String Order="SELECT * FROM book WHERE AuthorID = "+id;
    	Statement stmt;
		try {
			ArrayList<book> b=new ArrayList();
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			while(rs.next()){
				book b1=null;
	  			for (int i=1;i<=6;i++)
    	  			{
	  				
	  					if(i==1){
	  						String s=rs.getObject(1)+"";
	  						String s1=rs.getObject(2)+"";
	  						b1=new book(s,s1,name);
	  						//b1.name=(String)rs.getObject(2);
	  						System.out.println(s1);
	  						b.add(b1);
	  					}
	  					else rs.getObject(i);
    	  			}
    	  		
			}
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
      	 
   }

    public ArrayList<book> FindAllBook(){
  	  	String Order="SELECT * FROM book";
    	Statement stmt;
		try {
			ArrayList<book> b=new ArrayList();
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			String order="Select * from author where AuthorID=";
			while(rs.next()){
				book b1=null;
	  			for (int i=1;i<=6;i++)
    	  			{
	  				
	  					if(i==1){
	  						String s=rs.getObject(1)+"";
	  						String s1=rs.getObject(2)+"";
	  						b1=new book(s,s1,rs.getObject(3)+"");
	  						//b1.name=(String)rs.getObject(2);
	  						System.out.println(s1);
	  						b.add(b1);
	  						i=3;
	  					}
	  					else rs.getObject(i);
    	  			}
    	  		
			}
			for(int j=0;j<b.size();j++){
				book b2=b.get(j);
				String order1="select * from author where AuthorID="+b2.getoauther();
				Statement s=con.createStatement();
				ResultSet rs1=s.executeQuery(order1);
				if(rs1.next())b2.setOauther(rs1.getString(2));
			}
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
      	 
   }
    
    public void close(){
    	d.close();
    }
    
    
    public static void main(String args[]){
    	//BookTable bt=new BookTable();
    	//System.out.println(bt.Find("111111","").get(0).name);
    }
    
    
    
}
