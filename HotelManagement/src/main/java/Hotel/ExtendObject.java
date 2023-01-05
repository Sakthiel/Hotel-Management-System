package Hotel;
public class ExtendObject{
     int cust_id;
	 int roomNo;
	int extend_days;
	ExtendObject(int id,int num,int extend_days){
		cust_id = id;
		roomNo = num;
		this.extend_days = extend_days;
		}
	public int getCust_id() {
		return cust_id;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public int getExtend_days() {
		return extend_days;
	}
	
}