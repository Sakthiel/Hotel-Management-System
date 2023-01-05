package Hotel;

public class CObject {
	public int id;
	String name;
	int roomNo;
	String roomType;
	int numberOfPersons;
  public int getid() {
	  return id;
  }
  public CObject(int id, String name, int roomNo, String roomType, int numberOfPersons) {
	super();
	this.id = id;
	this.name = name;
	this.roomNo = roomNo;
	this.roomType = roomType;
	this.numberOfPersons = numberOfPersons;
}
public String getname() {
	  return name;
  }
  public int getroomNum() {
	  return roomNo;
	   }
  public String getroomType() {
	  return roomType;
  }
  public int getnum() {
	  return numberOfPersons;
  }
}
