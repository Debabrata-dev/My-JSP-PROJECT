package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/LoginForm")
public class Login extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	PrintWriter out=resp.getWriter();
	String myemail=req.getParameter("email1");
	String mypass=req.getParameter("pass1");
	Connection con=null;
	PreparedStatement ps=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_jsp?user=root&password=admin");
	    ps=con.prepareStatement("select * from register where email=? and password=?");
	    ps.setString(1, myemail);
	    ps.setString(2, mypass);
	   ResultSet rs= ps.executeQuery();
	   if(rs.next()) {
		  HttpSession session=req.getSession();
		  session.setAttribute("session_name", rs.getString("name"));
		  
		 RequestDispatcher rd=req.getRequestDispatcher("/Profile.jsp");
		 rd.include(req, resp);
	   }
	   else {
		   resp.setContentType("text/html");
		   out.println("<h3 style='color:red'>Email id and apssword didnot match</h3>");
		 RequestDispatcher rd=req.getRequestDispatcher("/Login.jsp");
		 rd.include(req, resp);
	   }
	} catch (ClassNotFoundException | SQLException e) {
		   resp.setContentType("text/html");
		   out.println("<h3 style='color:red'>Email id and apssword didnot match</h3>");
		 RequestDispatcher rd=req.getRequestDispatcher("/Login.jsp");
		 rd.include(req, resp);
		e.printStackTrace();
	}
	finally {
		try {
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
}
