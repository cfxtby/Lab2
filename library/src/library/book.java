package library;

public class book {
	public String name="";
	public String oauther="";
	public String ID="";
	public book(String id,String name,String oauther){
		this.name=name;
		this.oauther=oauther;
		this.ID=id;
	}
	
	
	public String getName(){
		return name;
	}
	
	public String getID(){
		return ID;
	}
	public void setID(String ID){
		this.ID=ID;
	}
	
	public String getoauther(){
		return oauther;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setOauther(String name){
		this.oauther=name;
	}
}
