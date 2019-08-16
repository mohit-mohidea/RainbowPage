package proj2;
import javax.servlet.http.*; 
import javax.servlet.*;  
import java.io.*;
import java.sql.*;
public class Register extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
	
		try
		{
			res.setContentType("text/html");//setting the content type
			Class.forName("com.mysql.jdbc.Driver");
			String conurl="jdbc:mysql://localhost:3306/user?useSSL=false";
			String nm=req.getParameter("name");
			Connection con=DriverManager.getConnection(conurl,"root","Mohit@9931");
			String em=req.getParameter("email");
			String psw=req.getParameter("pass");
			String g=req.getParameter("gender");
			PreparedStatement stmt=con.prepareStatement("insert into reguser values(?,?,?,?)");
			stmt.setString(1,nm);
			stmt.setString(2,em);
			stmt.setString(3,psw);
			stmt.setString(4,g);
			int i=stmt.executeUpdate();
			out.println("<html><body bgcolor='#FFFF00'>");
			out.println("<h2>your are registered Successfully.</h2>");
			out.println("<a style='font-size:150%' href='http://localhost:8080/proj2/index.html'>Go Back to Search Page</a>");
			out.println("</body></html>"); 
			con.close(); 
		 }
			
			catch(Exception e)
			{
				out.println(e);
			}
	}

}
