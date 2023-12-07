

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DataRetriveServlet")
public class DataRetriveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String s1=request.getParameter("userId");
		String s2=request.getParameter("password");
		
		out.println("<html><body>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mdj55","root","root");
			
			PreparedStatement stat=con.prepareStatement("select * from user where uid=? and pwd=?");
			stat.setString(1, s1);
			stat.setString(2, s2);
			
			ResultSet rs=stat.executeQuery();
			if(rs.next())
				out.println("<h1>Welcome "+ s1 +"</h1>");
			else
				out.println("<h1>Login Failed..</h1>");
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
