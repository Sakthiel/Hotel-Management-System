package Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDB {
	void insert(int id,String domain,String complaint) throws ClassNotFoundException, SQLException {
		Room r = new Room();
		Connection conn=r.getConnection();
		String query = "insert into complaints(cust_id,category,complaint)values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
	    ps.setInt(1,id);
	    ps.setString(2,domain);
	    ps.setString(3,complaint);
	     ps.executeUpdate();
	     ps.close();
	     conn.close();
	}
	public List<ComplaintObject> complaint_list(int id) throws ClassNotFoundException, SQLException{
		List <ComplaintObject> list = new ArrayList<ComplaintObject>();
		Room r  = new Room();
		String result;
		Connection conn = r.getConnection();
		String query = "select * from complaints where cust_id = " + id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			ComplaintObject co = new ComplaintObject(rs.getInt("complaint_id"),rs.getString("category"),
					                                   rs.getString("complaint"),rs.getString("status"));
		list.add(co);
		
		}
		stmt.close();
		conn.close();
		return list;
	}
	public List<ComplaintObject> total_complaint_list() throws ClassNotFoundException, SQLException{
		List <ComplaintObject> list = new ArrayList<ComplaintObject>();
		Room r  = new Room();
		Connection conn = r.getConnection();
		String query = "select * from complaints ";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			ComplaintObject co = new ComplaintObject(rs.getInt("complaint_id"),rs.getString("category"),
					                                   rs.getString("complaint"),rs.getString("status"));
		list.add(co);
		
		}
		stmt.close();
		conn.close();
		return list;
	}
	public void updateComplaint(int id) throws ClassNotFoundException, SQLException {
		Room r  = new Room();
		Connection conn = r.getConnection();
		String query = "update complaints set status = 'Verified' where complaint_id = "+id ;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		conn.close();
	}

}
