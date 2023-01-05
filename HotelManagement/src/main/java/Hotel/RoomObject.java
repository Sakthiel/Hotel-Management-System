package Hotel;

public class RoomObject {
	public int RoomNo;
	public String RoomType;
	public int PricePerDay;
	public String status;
	RoomObject(int RoomNo,String RoomType,int PricePerDay){
		this.RoomNo = RoomNo;
		this.RoomType = RoomType;
		this.PricePerDay = PricePerDay;
	}
	 RoomObject(int roomNo, String roomType, int pricePerDay, String status) {
		RoomNo = roomNo;
		RoomType = roomType;
		PricePerDay = pricePerDay;
		this.status = status;
	}
	
	

}
