import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet("/BankLoginServlet")
public class BankLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mdj55","root","root");
			PreparedStatement stat=con.prepareStatement("select * from useraccount where uid=? and pwd=?");
			stat.setString(1, request.getParameter("t1"));
			stat.setString(2, request.getParameter("t2"));
			
			ResultSet rs=stat.executeQuery();
			if(rs.next()) {
				out.println("<center><h1>Welcome "+rs.getString(1)+"</h1><br><br><form method='post' action='GetBalServlet'>");
				out.println("Enter Account No:<input type='text' name='t3'><br><br>");
				out.println("<input type='submit' value='Submit'>");
			}
			else {
				out.println("<h2>Login Failed</h2>");
			}
			out.println("</form></center>");
			rs.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		out.println("</body></html>");
		out.close();	
	}

}
