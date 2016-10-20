package library;

import java.util.ArrayList;

import SQL.BookTable;
import SQL.DbUtil;
import SQL.autherTable;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateInfo extends ActionSupport{
	private String ISBN , Title,  Publisher, PublishDate, Price;
	private String AuthorID , Name, Age, Country,order;
	
	public String book(){
		DbUtil d=new DbUtil();
		BookTable bt=new BookTable(d);
		ArrayList<String> b=bt.get(ISBN);
		autherTable at=new autherTable(d);
		ArrayList<String> sID=at.FindID(Name);
		if(sID.size()<1)return "new_a_ok";
		if(b==null)return "error";
		AuthorID=b.get(2);
		ArrayList<String> info=new ArrayList<String>();
		info.add(ISBN);
		info.add(Title);
		info.add(sID.get(0));
		info.add(Publisher);
		info.add(PublishDate);
		info.add(Price);
		order="更新";
		if(bt.Delete(ISBN)&&bt.Insert(info)){
			d.close();
			return "update_ok";}
		else{ 
			d.close();
			return "error";}
	}
	
	public String newAuthor(){
		DbUtil d=new DbUtil();
		autherTable at=new autherTable(d);
		BookTable bt=new BookTable(d);
		AuthorID=at.getNewID();
		order="插入";
		ArrayList<String> info=new ArrayList<String>();
		if(ISBN==null)ISBN=bt.getNewID();
		else bt.Delete(ISBN);
		info.add(ISBN);
		info.add(Title);
		info.add(AuthorID);
		info.add(Publisher);
		info.add(PublishDate);
		info.add(Price);
		if(Price.matches("\\d+")){
			
			if(at.insert(AuthorID, Name,Age,Country)&&bt.Insert(info)){
				d.close();
				return "new_ok";
			}
				
			else {
				d.close();
				return "error";
			}
		}
		d.close();
		return "error";
	}
	
	public String newbook(){
		DbUtil d=new DbUtil();
		BookTable bt=new BookTable(d);
		autherTable at=new autherTable(d);
		boolean flag=false;
		order="插入";
		//System.out.println(ISBN+Title);
		synchronized (ActionSupport.class) {
			ArrayList<String> auther=at.FindID(Name);
			if(auther.size()<1){
				flag=true;
				d.close();
				//AuthorID=at.getNewID();
				//if(!at.insert(AuthorID,Name))return "error";
			}
			else {
				AuthorID=auther.get(0);
				ArrayList<String> info=new ArrayList<String>();
				ISBN=bt.getNewID();
				info.add(ISBN);
				info.add(Title);
				info.add(AuthorID);
				info.add(Publisher);
				info.add(PublishDate);
				info.add(Price);
				boolean flag1=bt.Insert(info);
				d.close();
				if(flag1)return "new_ok";
				else return "error";
			}
		}

		if(flag)return "new_a_ok";
		else{ return "error";}
	}
	
	
	public String getOrder() {
		return order;
	}


	public void setOrder(String order) {
		this.order = order;
	}

	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
}
