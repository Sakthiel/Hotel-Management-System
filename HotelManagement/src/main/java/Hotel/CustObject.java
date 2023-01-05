package Hotel;

public class CustObject {
	int id;
	String name;
	String mobileNumber;
	String gender;
	String idproof;
	
	public CustObject(int id, String name, String mobileNumber, String gender, String idproof) {
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.idproof = idproof;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public String getIdproof() {
		return idproof;
	}

}
