package proj2;
import javax.servlet.http.*; 
import javax.servlet.*;  
import java.io.*;
import java.sql.*;
public class LogIn extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
	
		try
		{
			res.setContentType("text/html");//setting the content type
			Class.forName("com.mysql.jdbc.Driver");
			String conurl="jdbc:mysql://localhost:3306/user?useSSL=false";
			Connection con=DriverManager.getConnection(conurl,"root","Mohit@9931");
			String em=req.getParameter("email");
			String psw=req.getParameter("pass");
			
			PreparedStatement ps = con.prepareStatement("select email,password from reguser where email=? and password=?");
			ps.setString(1, em);
			ps.setString(2, psw);
	        ResultSet rs = ps.executeQuery(); 
	        if(rs.next())
	        {
			out.println("<html><body bgcolor='#FFFF00'>");
			out.println("<h2>your are Logged In Successfully.</h2>");
			out.println("<a style='font-size:150%' href='http://localhost:8080/proj2/index.html'>Go Back to Search Page</a>");
			out.println("</body></html>");
	        }
	        else
	        {
	        	out.println("<html><body bgcolor='#FFFF00'>");
				out.println("<h2>Check Username and Password.</h2>");
				out.println("<a style='font-size:150%' href='http://localhost:8080/proj2/index.html'>Go Back to Search Page</a>");
				out.println("</body></html>");
	        }
	        	
			con.close(); 
		 }
			
			catch(Exception e)
			{
				out.println(e);
			}
	}

}
