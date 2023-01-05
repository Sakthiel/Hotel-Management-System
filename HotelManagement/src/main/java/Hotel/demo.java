package Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*public class demo {
	
	int book(String checkIn,int roomNum,int days,int persons,int id) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		String query;
		Statement s = conn.createStatement();
		query = "select price_per_day from room where roomNo = "+roomNum ; 
		
		ResultSet rs = s.executeQuery(query);
		rs.next();
		int price = rs.getInt(1);
		int total = price*days;
		query = "insert into customers(roomNo,numberOfPersons,numberOfDaysStay,"
				+ "totalAmount,checkIn,id,booked_date,checkOut) values(?,?,?,?,?,?,curdate(),date_add(checkIn,interval numberOfDaysStay day))";
	    PreparedStatement ps = conn.prepareStatement(query);
	    ps.setInt(1,roomNum);
	    ps.setInt(2,persons);
	    ps.setInt(3,days);
	    ps.setInt(4,total);
	    ps.setString(5,checkIn); 
	    ps.setInt(6,id);
	    ps.executeUpdate();
	    
	    query ="update room set status = 'booked' where roomNo =" + roomNum ;
	    s.executeUpdate(query);
	    s.close();
	    ps.close();
	    conn.close();
	    return total;
	    
	}
	
	public List  availability() throws ClassNotFoundException, SQLException {
		int RoomNo;
		String RoomType;
		int PricePerDay;
		List <RoomObject> available_list = new ArrayList<RoomObject>();
		List<RoomObject> list = new ArrayList<RoomObject>();
		Room r  = new Room();
		String result;
		Connection conn = r.getConnection();
		String query = "select * from room where status = 'NotBooked'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			RoomNo = rs.getInt(1);
			RoomType = rs.getString(2);
			PricePerDay = rs.getInt(3);
			RoomObject ro = new RoomObject(RoomNo,RoomType,PricePerDay);
			available_list.add(ro);
			}
		query = "select roomNo,roomType,price_per_day from customers c join room r on c.roomNo = r.roomNo where checkOut < " + indate ;
		ResultSet ps = stmt.executeQuery(query);
		
		while(ps.next()) {
			RoomNo = rs.getInt(1);
			RoomType = rs.getString(2);
			PricePerDay = rs.getInt(3);
			RoomObject ro = new RoomObject(RoomNo,RoomType,PricePerDay);
			list.add(ro);
		}
		available_list.addAll(list);
		//while(rs.next()) {
			//result = "RoomNo: " + rs.getInt(1) +"&emsp;  RoomType: " +rs.getString(2) +"&emsp; PricePerDay: " +rs.getInt(3);
			//available_list.add(result);
		//}
		stmt.close();
		conn.close();
		return available_list; 
		
	}
	
	
	

}*/
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateString {
   public static void main(String args[]) throws Exception{
      String date = "21-9-2017";
      SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-YYYY");
      Date result = sdt.parse(date);
      System.out.println(result);
   }
}
