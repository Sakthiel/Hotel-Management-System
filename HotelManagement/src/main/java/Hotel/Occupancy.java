package Hotel;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/Occupancy1")
public class Occupancy extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Room r = new Room();
		List list = null;
		try {
			list = r.occupiedlist();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		request.setAttribute("olist",list);
		 RequestDispatcher rd = request.getRequestDispatcher("RoomsOccupied.jsp");
		rd.forward(request,response);
	}

	


}
