package Hotel;
import java.sql.* ;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Register1")
public class ToRegister extends HttpServlet {
	String name,password,mobilenumber,gender,idproof,type;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(); 
		name = request.getParameter("uname");
		 mobilenumber = request.getParameter("phone");
		 password = request.getParameter("pass");
		 gender = request.getParameter("gender");
		 idproof = request.getParameter("proof");
		 type = request.getParameter("type");
	     try {
			Insert();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
		    System.out.println(e.getMessage());
		}
	     
	 if(type.equals("customer")) {
	    response.sendRedirect("LoginPage.jsp"); 
	 }
	 else {
		 request.setAttribute("name",name);
         request.setAttribute("process","addcustomer");  
	    	RequestDispatcher rd = request.getRequestDispatcher("AComplete.jsp");
		    rd.forward(request,response);
	    	
	 }
	   
	}
void Insert() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/hotel" ;
    String uname = "root" ;        
    String pass = "sakthi" ;
    String query = "insert into users(name,password,mobilenumber,gender,idproof) values (?,?,?,?,?)" ;
    Connection conn = DriverManager.getConnection(url,uname,pass);
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1,name);
    ps.setString(2,password);
    ps.setString(3,mobilenumber);
    ps.setString(4,gender);
    ps.setString(5,idproof);
	ps.executeUpdate();
	/*Statement stmt = conn.createStatement();
	query = "select type from users where mobilenumber ="+mobilenumber;
	ResultSet rs = stmt.executeQuery(query);
	type = rs.getString(1);*/
	ps.close();
	conn.close();
}

}
