package Hotel;

import jakarta.servlet.ServletException;
import java.sql.* ;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Login")
public class ToLogin extends HttpServlet {
	boolean flag;
	String username;
	String password;
	String type;
	int id;
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   username = request.getParameter("uname");
   		   password = request.getParameter("pass");
   		    HttpSession session = request.getSession();
   		   try {
			check();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		   
   		   if(flag && type.equals("customer")) {
   			   session.setAttribute("name",username);
			   session.setAttribute("id",id);
			   session.setAttribute("type",type);
   			   response.sendRedirect("CHome.jsp");
   		   }
   		   else if(flag && type.equals("admin")) {
   			   session.setAttribute("name",username);
			   session.setAttribute("id",id);
			   session.setAttribute("type",type);
   			   response.sendRedirect("AHome.jsp");
   		   }
   		   else {
   			   response.sendRedirect("Login.jsp");
   		   }
		}
       void check() throws SQLException, ClassNotFoundException {
    	   Class.forName("com.mysql.jdbc.Driver");
    	   String url = "jdbc:mysql://localhost:3306/hotel" ;
    	   String uname = "root" ;        
    	   String pass = "sakthi" ;
    	   String query = "select * from users where name = ? and password = ?" ;
    	   Connection conn = DriverManager.getConnection(url,uname,pass);
    	   PreparedStatement ps = conn.prepareStatement(query);
    	   ps.setString(1,username);
    	   ps.setString(2, password);
    	   ResultSet rs = ps.executeQuery();
    	   flag = rs.next();
    	   if(flag) {
    	   type = rs.getString("type");
    	   id = rs.getInt("id");
    	   }
    	   
       }

}
