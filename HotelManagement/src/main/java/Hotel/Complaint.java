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

@WebServlet("/Complaint1")
public class Complaint extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
		String domain=request.getParameter("domain");
		String complaint=request.getParameter("complaint");
		ComplaintDB comp = new ComplaintDB();
		try {
			comp.insert(id,domain,complaint);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		request.setAttribute("type","complaint");
		request.setAttribute("from","customer");
		RequestDispatcher rd = request.getRequestDispatcher("Complete.jsp");
		rd.forward(request,response);
	}

	
	

}
