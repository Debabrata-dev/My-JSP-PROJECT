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
@WebServlet("/regForm")
public class Register extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String Name=req.getParameter("name1");
	String Email=req.getParameter("email");
	String mypass=req.getParameter("pass1");
	String Mygender=req.getParameter("gender1");
	String myCity=req.getParameter("city1");
    PrintWriter out=resp.getWriter();
Connection con=null;	
PreparedStatement ps=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_jsp?user=root&password=admin");
	ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
	ps.setString(1, Name);
	ps.setString(2, Email);
	ps.setString(3, mypass);
	ps.setString(4, Mygender);
	ps.setString(5, myCity);
	
	int count=ps.executeUpdate();
	if(count>0) {
		resp.setContentType("text/html");
		out.print("<h3 'color:green'>USER Register Successufllly</h3>");
		RequestDispatcher rd=req.getRequestDispatcher("/From.jsp");
		rd.include(req, resp);
	}
	else {
		resp.setContentType("text/html");
		out.print("<h3 'color:red'>USER Not Register Successufllly</h3>");
		RequestDispatcher rd=req.getRequestDispatcher("/From.jsp");
		rd.include(req, resp);
		System.out.println("Error");
	}
}
	catch(Exception e) {
		resp.setContentType("text/html");
		out.print("<h3 'color:red'>USER Not Register Successufllly</h3>");
		RequestDispatcher rd=req.getRequestDispatcher("/From.jsp");
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
