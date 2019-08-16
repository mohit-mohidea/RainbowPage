package proj2;
import javax.servlet.http.*; 
import javax.servlet.*;  
import java.io.*;
import java.sql.*;
public class SearchFor extends HttpServlet 
{
	
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		 
		try
		{
		res.setContentType("text/html");//setting the content type
		Class.forName("com.mysql.jdbc.Driver"); 
		String l=req.getParameter("loc");
		String conurl="jdbc:mysql://localhost:3306/"+l+"?useSSL=false";
		String sf=req.getParameter("sfor");
		Connection con=DriverManager.getConnection(conurl,"root","Mohit@9931");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from "+sf);  
		
		out.println("<html><body bgcolor='#FFFF00'>"); 
		int i=1;
		while(rs.next()) 
		{
			out.println("<h1>"+i+". "+rs.getString(2)+"</h1>");
			//out.println("<br>");
			out.println("<p style='font-size:150%'>"+"<b>Address-<b>"+rs.getString(3)+"</p>");
			out.println("<p><b><u>Visit us on:</u></b>   "+rs.getString(4)+"</p>");
			out.println("<p><b><u>Contact us on:</u></b>    "+rs.getString(5)+"</p>");
			out.println("<hr>");
			i++;
		}
		out.println("</body></html>"); 
		
		con.close();  
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}	
}

