package Hotel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;  
import java.util.*;
import java.util.Date;
import java.util.Calendar;   
import java.text.ParseException;

public class Room {
	static int AvailableRooms =20;
	static int Occupied = 0;
	static int room_id = 0; 
	
	
	Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hotel" ;
	    String uname = "root" ;        
	    String pass = "sakthi" ;
	    Connection conn = DriverManager.getConnection(url,uname,pass);
	    return conn;
	    }
	
	int book(String checkIn,int roomNum,int days,int persons,int id) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		String query;
		Statement s = conn.createStatement();
		query = "select price_per_day from room where roomNo = "+roomNum ; 
		
		ResultSet rs = s.executeQuery(query);
		rs.next();
		int price = rs.getInt(1);
		int total = price*days;
		query =  "insert into customers(roomNo,numberOfPersons,numberOfDaysStay,"
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
	void cancel(int id,int roomNum) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		String query = "delete from customers where roomNo ="+roomNum +" and id ="+ id;
	  Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
		
		query = "select * from customers where roomNo = "+roomNum;
		ResultSet rs = stmt.executeQuery(query);
		if(!rs.next()) {
		query = "update room set status = 'NotBooked' where roomNo ="+ roomNum;
		stmt.executeUpdate(query);
		}
		query = "delete from extension where roomNo = "+roomNum;
		stmt.executeUpdate(query);
		conn.close();
		stmt.close();
		}
	void addRoom(String roomType,int price) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		String query = "insert into room (roomType,price_per_day) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,roomType);
		ps.setInt(2, price);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	String deleteRoom(int roomNum) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement(); 
		String roomType;
		String query = "select roomType from room where roomNo = "+roomNum;
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		roomType = rs.getString(1);
		query = "delete from room where roomNo = "+roomNum;
		stmt.executeUpdate(query);
		stmt.close();
		conn.close();
		return roomType;
	}
	public List<CObject> occupiedlist() throws ClassNotFoundException, SQLException {
		List <CObject> list = new ArrayList<CObject>();
		Room r  = new Room();
		int id,roomNo,persons;
		String name,roomType;
		Connection conn = r.getConnection();
		String query = "select c.id,name,c.roomNo,roomType,numberOfPersons from customers c join room r on c.roomNo = r.roomNo join users u on c.id = u.id";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			id = rs.getInt(1);
			name = rs.getString(2);
			roomNo = rs.getInt(3);
			roomType = rs.getString(4);
			persons = rs.getInt(5);
			CObject o = new CObject(id,name,roomNo,roomType,persons);
			list.add(o);
		}
		stmt.close();
		conn.close();
		return list;
	   }
	int Extend(int id,int roomNum,int days) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		String query = "update customers set numberOfDaysStay ="+days+"+ numberOfDaysStay where roomNo ="+roomNum+" and id ="+id; 
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
		int price;
		query = "select price_per_day from room where roomNo ="+roomNum;
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		price = rs.getInt(1);
		
		query = "update customers set totalAmount = numberOfDaysStay * "+price+" where roomNo = "+roomNum+" and id = "+id;
		stmt.executeUpdate(query);
		
		int total;
		query = "select totalAmount from customers where roomNo = "+roomNum+" and id = "+id;
		ResultSet ss = stmt.executeQuery(query);
		ss.next();
		total = ss.getInt(1);
		
		query = "update customers set checkOut = date_add(checkIn,interval numberOfDaysStay day) where roomNo = "+roomNum+" and id="+id;
		stmt.executeUpdate(query);
		
		
		query = "insert into Extension values(?,?,?)";
	    PreparedStatement ps = conn.prepareStatement(query);
	    ps.setInt(1,id);
	    ps.setInt(2,roomNum);
	    ps.setInt(3,days);
	    ps.executeUpdate();
	    ps.close();
	    stmt.close();
	    conn.close();
	    return total;
		
	}
	public List  availability(String indate) throws ClassNotFoundException, SQLException, ParseException {
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
		
		/*LocalDate date1 = LocalDate.of(Integer.parseInt(indate.substring(0,4)),Integer.parseInt(indate.substring(5,7)),
				                        Integer.parseInt(indate.substring(8))); */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		Date rdate =  sdf.parse(indate);  
		query = "select max(checkOut) from customers";
	    ResultSet as = stmt.executeQuery(query);
	    as.next();
	    Date date2 = as.getDate(1);
	    
	    
	    Calendar cal1 = Calendar.getInstance();   
	    Calendar cal2 = Calendar.getInstance();   
	    cal1.setTime(rdate);   
	    cal2.setTime(date2); 
	    String sdate = sdf.format(date2);
	    
	    if(cal1.after(cal2)) {
		query = "select c.roomNo,roomType,price_per_day from customers c join room r on c.roomNo = r.roomNo where checkOut = ?" ;
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,sdate);
		ResultSet ls = ps.executeQuery();
		while(ls.next()) {
			RoomNo = ls.getInt(1);
			RoomType = ls.getString(2);
			PricePerDay = ls.getInt(3);
			RoomObject ro = new RoomObject(RoomNo,RoomType,PricePerDay);
			list.add(ro);
		}
		ls.close();
		ps.close();
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
	public List<BookedRoom> booked(int id) throws ClassNotFoundException, SQLException {
		Room r= new Room();
		Connection conn = r.getConnection();
		List<BookedRoom> list = new ArrayList<BookedRoom>();
		String query = "select r.roomNo,roomType,totalAmount,numberOfDaysStay from customers c join room r on c.roomNo = r.roomNo where id ="+id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		int num,amount,days;
		String type;
		while(rs.next()) {
		num = rs.getInt(1);
		type = rs.getString(2);
		amount = rs.getInt(3);
		days = rs.getInt(4);
		BookedRoom br = new BookedRoom(num,type,amount,days);
		list.add(br);
		}
	    stmt.close();
		rs.close();
		return list;
	}
	public List<ExtendObject> extendlist(int id) throws ClassNotFoundException, SQLException{
		Room r= new Room();
		Connection conn = r.getConnection();
		List<ExtendObject> list = new ArrayList<ExtendObject>();
		String query = "select id,roomNo,sum(extendedDays) from extension group by roomNo having id ="+id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
		int cust_id = rs.getInt(1);
		int roomNo = rs.getInt(2);
		int days = rs.getInt(3);
		ExtendObject eo = new ExtendObject(cust_id,roomNo,days);
		list.add(eo);
		}
		stmt.close();
		conn.close();
		return list;
		}
	public int totalAmount(int id) throws ClassNotFoundException, SQLException {
		Room r= new Room();
		Connection conn = r.getConnection();
		String query = "select sum(totalAmount) from customers where id ="+id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		int total;
		rs.next();
		total = rs.getInt(1);
		return total;
	}
	public List <CustObject> cust_details() throws ClassNotFoundException, SQLException{
		int id;
		String name;
		String mobileNumber;
		String gender;
		String idproof;
		Room r= new Room();
		Connection conn = r.getConnection();
		List<CustObject> list = new ArrayList<CustObject>();
		String query = "select * from users where type = 'customer'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			id = rs.getInt("id");
			name = rs.getString("name");
			mobileNumber = rs.getString("mobilenumber");
			gender = rs.getString("gender");
			idproof = rs.getString("idproof");
			CustObject co = new CustObject(id,name,mobileNumber,gender,idproof);
			list.add(co);
		}
		stmt.close();
		conn.close();
		return list;
		}
	public String deleteCustomer(int id) throws ClassNotFoundException, SQLException {
		Room r = new Room();
		String name;
		Connection conn = r.getConnection();
		String query = "select name from users where id = "+id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		name = rs.getString(1);
		
		query = "delete from users where id = "+id;
		stmt.executeUpdate(query);
		stmt.close();
		conn.close();
		return name;
	}
	public List<RoomObject> roomdetails() throws ClassNotFoundException, SQLException{
		int RoomNo;
		String RoomType;
		int PricePerDay;
		String status;
		List <RoomObject> list = new ArrayList<RoomObject>();
		Room r  = new Room();
		Connection conn = r.getConnection();
		String query = "select * from room ";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			RoomNo = rs.getInt(1);
			RoomType = rs.getString(2);
			PricePerDay = rs.getInt(3);
			status = rs.getString(4);
			RoomObject ro = new RoomObject(RoomNo,RoomType,PricePerDay,status);
			list.add(ro);
			}
		stmt.close();
		conn.close();
		return list;
	}
	public List<DateObject> inoutdates() throws ClassNotFoundException, SQLException{
		int id;
		int roomNo;
		Date checkIn;
		Date checkOut;
		List <DateObject> list = new ArrayList<DateObject>();
		Room r  = new Room();
		Connection conn = r.getConnection();
		String query = "select id,roomNo,checkIn,date_add(checkIn,interval numberOfDaysStay day) as checkOut from customers";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			id = rs.getInt(1);
			roomNo = rs.getInt(2);
			checkIn = rs.getDate(3);
			checkOut = rs.getDate(4);
			DateObject object = new DateObject(id,roomNo,checkIn.toString(),checkOut.toString());
			list.add(object);
		}
		
		stmt.close();
		conn.close();
		return list;
		
	}
	public List<IncomeObj> cincome() throws ClassNotFoundException, SQLException{
		int id;
		String name;
		int cost;
		List <IncomeObj> list = new ArrayList<IncomeObj>();
		Room r  = new Room();
		Connection conn = r.getConnection();
		String query = "select c.id,name,sum(totalAmount) from customers c join users u on c.id = u.id group by id";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			id = rs.getInt(1);
			name = rs.getString(2);
			cost = rs.getInt(3);
			IncomeObj io = new IncomeObj(id,name,cost);
			list.add(io);
		}
		stmt.close();
		conn.close();
		return list;
	}
	public int totalRevenue() throws ClassNotFoundException, SQLException {
		int total;
		Room r  = new Room();
		Connection conn = r.getConnection();
		String query = "select sum(totalAmount) from customers";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		total = rs.getInt(1);
		stmt.close();
		conn.close();
		return total;
	}
	public List<revRoomType> roomIncome() throws ClassNotFoundException, SQLException{
		String roomtype;
		int Amount;
		List <revRoomType> list = new ArrayList<revRoomType>();
		Room r  = new Room();
		Connection conn = r.getConnection();
		String query = "select roomType,sum(totalAmount) from customers c join room r on c.roomNo = r.roomNo group by roomType";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			roomtype = rs.getString(1);
			Amount = rs.getInt(2);
			revRoomType rt = new revRoomType(roomtype,Amount);
			list.add(rt);
		}
		stmt.close();
		conn.close();
		return list;
	}
}


