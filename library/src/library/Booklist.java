package library;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;







import SQL.BookTable;
import SQL.DbUtil;
import SQL.autherTable;

import com.opensymphony.xwork2.ActionSupport;

public class Booklist extends ActionSupport {
    private String name,ID,order;
    public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	private String[] bookR;
	public String[] getBookR() {
		return bookR;
	}

	public void setBookR(String[] bookR) {
		this.bookR = bookR;
	}

	private List<book> books;
    private List<String> book;
    public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}


    public List<String> getBook() {
		return book;
	}

	public void setBook(List<String> book) {
		this.book = book;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	private String bookId;
    

    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setBooks(List<book> b){
    	this.books=b;
    }
    
    public List<book> getBooks(){
    	return books;
    }
    
    public String allBook(){
    	DbUtil d=new DbUtil();
    	BookTable bt=new BookTable(d);
    	books=bt.FindAllBook();
    	return "list";
    }
    
    public String refresh()
    {
    	DbUtil d=new DbUtil();
    	BookTable bt=new BookTable(d);
    	ArrayList l=bt.get(ID);
    	bookR=new String[6];
    	d.close();
    	if(l!=null)
    	return "REFRESH";
    	else return "error";
    }
    
    
    public String detail(){
    	DbUtil d=new DbUtil();
    	BookTable bt=new BookTable(d);
    	autherTable auth=new autherTable(d);
    	book=bt.get(ID);
    	if(book==null)return "error";
    	ArrayList<String> a=auth.Find(book.get(2));
    	book.addAll(a);
    	d.close();
    	if(book.size()<10)return "error";
    	return "detail";
    }

    public String delete(){
    	DbUtil d=new DbUtil();
    	BookTable bt=new BookTable(d);
    	autherTable auth=new autherTable(d);
    	boolean flag=false;
    	flag=bt.Delete(ID);
    	d.close();
    	if(flag)return "delete";
    	else return "error";
    }
    
    public String execute() {
    	DbUtil d=new DbUtil();
    	BookTable bt=new BookTable(d);
		//创建book的对象的动态链表
    	order="查询";
    	autherTable at=new autherTable(d);
    	ArrayList<String> arr=at.FindID(name);
    	System.out.println(name);
    	if(arr==null)return "error";
    	books=new ArrayList<book>();
    	for(int i=0;i<arr.size();i++){
    		books.addAll(bt.Find(arr.get(i),name));
			//添加每一个重名作者的图书
    	}
        d.close();
        return "list";
    }
}
