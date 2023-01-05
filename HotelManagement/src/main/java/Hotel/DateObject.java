package Hotel;

public class DateObject {
	int id;
	int roomNo;
	String CheckIn;
	String CheckOut;
	public DateObject(int id, int roomNo, String checkIn, String checkOut) {
		this.id = id;
		this.roomNo = roomNo;
		CheckIn = checkIn;
		CheckOut = checkOut;
	}
	public int getId() {
		return id;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public String getCheckIn() {
		return CheckIn;
	}
	public String getCheckOut() {
		return CheckOut;
	}
	

}
