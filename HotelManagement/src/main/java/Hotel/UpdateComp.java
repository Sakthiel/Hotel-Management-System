package Hotel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdateComp1")
public class UpdateComp extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ComplaintDB db = new ComplaintDB();
		try {
			db.updateComplaint(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		request.setAttribute("process","updateComplaint");
		request.setAttribute("id",id);
		RequestDispatcher rd = request.getRequestDispatcher("AComplete.jsp");
		rd.forward(request, response);
	}


}
