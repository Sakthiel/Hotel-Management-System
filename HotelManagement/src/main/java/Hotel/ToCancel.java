package Hotel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ToCancel1")
public class ToCancel extends HttpServlet {
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		
		int roomNum = Integer.parseInt(request.getParameter("roomNum"));
		Room r= new Room();
		try {
			r.cancel(id,roomNum);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("type","cancel");
		request.setAttribute("from","customer");
		request.setAttribute("roomNum",roomNum);
		RequestDispatcher rd = request.getRequestDispatcher("Complete.jsp");
		rd.forward(request,response);
		
		
		
	}


	}


