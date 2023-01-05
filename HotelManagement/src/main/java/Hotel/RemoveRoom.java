package Hotel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Remove")
public class RemoveRoom extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               int roomNum = Integer.parseInt(request.getParameter("roomNum"));
               Room r = new Room();
               String roomType = null;
               try {
				roomType = r.deleteRoom(roomNum);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
               request.setAttribute("process","deleteroom");
       		request.setAttribute("from","admin");
       		request.setAttribute("roomNo",roomNum);
       		request.setAttribute("roomType",roomType);
       		RequestDispatcher rd = request.getRequestDispatcher("AComplete.jsp");
       		rd.forward(request,response); 
	}

}
