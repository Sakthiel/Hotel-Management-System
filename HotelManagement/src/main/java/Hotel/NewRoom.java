package Hotel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/NewRoom1")
public class NewRoom extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomType = request.getParameter("type");
	    int price =Integer.parseInt(request.getParameter("price"));
		Room r= new Room();
		try {
			r.addRoom(roomType,price);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		request.setAttribute("process","addroom");
		request.setAttribute("from","admin");
		request.setAttribute("roomType",roomType);
		request.setAttribute("price",price);
		RequestDispatcher rd = request.getRequestDispatcher("AComplete.jsp");
		rd.forward(request,response);
	}



}
