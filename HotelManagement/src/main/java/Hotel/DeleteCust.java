package Hotel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteCust1")
public class DeleteCust extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = null;
		Room r = new Room();
		try {
			name=r.deleteCustomer(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		request.setAttribute("process","deletecustomer");  
		request.setAttribute("name",name);
    	RequestDispatcher rd = request.getRequestDispatcher("AComplete.jsp");
	    rd.forward(request,response);
		

	

}
}
