package Hotel;

public class ComplaintObject {
	int id;
	String domain;
	String complaint;
	String status;
	ComplaintObject(int id,String domain,String complaint,String status){
		this.id = id;
		this.domain = domain;
		this.complaint = complaint;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public String getDomain() {
		return domain;
	}
	public String getComplaint() {
		return complaint;
	}
	public String getStatus() {
		return status;
	}
	

}
