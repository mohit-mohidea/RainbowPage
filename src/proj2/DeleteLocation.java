package proj2;
import javax.servlet.http.*; 
import javax.servlet.*;  
import java.io.*;
import java.sql.*;
public class DeleteLocation extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		 
		try
	  {
		res.setContentType("text/html");//setting the content type
		Class.forName("com.mysql.jdbc.Driver");
		String l=req.getParameter("locadd");
		String conurl="jdbc:mysql://localhost:3306/"+l+"?useSSL=false";
		String np=req.getParameter("nplace");
		Connection con=DriverManager.getConnection(conurl,"root","Mohit@9931");
		String plid=req.getParameter("pid");
		PreparedStatement stmt=con.prepareStatement("delete from "+np+" where id=?");  
		stmt.setString(1,plid);
		int i=stmt.executeUpdate();
		out.println("<html><body bgcolor='#FFFF00'>");
		out.println("<h2>Successfully Removed a place</h2>");
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
