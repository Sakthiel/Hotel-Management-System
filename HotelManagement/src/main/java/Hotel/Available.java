package Hotel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.util.*;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Available1")
public class Available extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	           /* try {
					list = availability();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}*/
	            
	            RequestDispatcher rd = request.getRequestDispatcher("RoomsAvailable1.jsp");
				rd.forward(request,response);
				
	}
	
 
	
	
	List availability() throws ClassNotFoundException, SQLException {
		List <String> available_list = new ArrayList<String>();
		Room r  = new Room();
		String result;
		Connection conn = r.getConnection();
		String query = "select * from room where status = 'NotBooked'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		//while(rs.next()) {
			//result = "RoomNo: " + rs.getInt(1) +"&emsp;  RoomType: " +rs.getString(2) +"&emsp; PricePerDay: " +rs.getInt(3);
			//available_list.add(result);
		//}
		stmt.close();
		conn.close();
		return available_list;
		
	}


}
