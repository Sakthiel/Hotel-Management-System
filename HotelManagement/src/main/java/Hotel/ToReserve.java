package Hotel;

import jakarta.servlet.RequestDispatcher;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/Reserve1")
public class ToReserve extends HttpServlet {
	int roomNumber;
	boolean flag;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkIn;
		int roomNum ,days,persons,price = 0;
		checkIn = request.getParameter("date");
	    roomNum = Integer.parseInt(request.getParameter("roomNo"));
		days = Integer.parseInt(request.getParameter("days"));
		persons = Integer.parseInt(request.getParameter("pnum"));
		roomNumber= roomNum;
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		
		
		/*try {
			check();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}*/
		
		Room r = new Room();
		try {
			price = r.book(checkIn,roomNum,days,persons,id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("type","reserve");
		request.setAttribute("total",price);
		request.setAttribute("roomNo",roomNum);
		
		/*else {
			request.setAttribute("type","noreserve");
		
		}*/
		request.setAttribute("from","customer");
		RequestDispatcher rd = request.getRequestDispatcher("Complete.jsp");
		rd.forward(request,response);
	}
	
	/*void check() throws ClassNotFoundException, SQLException {
		Room r= new Room();
		Connection conn=r.getConnection();
		String query = "select status from room where roomNo ="+roomNumber;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		if(rs.getString(1).equals("NotBooked")) {
			flag = true;
		}
		else {
			flag = false;
		}*/
		
	

	

}
