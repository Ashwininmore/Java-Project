

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudServlet")
public class StudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mdj55","root","root");
			
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from student");
		
			out.println("<table border=2>");
			out.println("<tr><th>RollNo</th><th>Name</th><th>Address</th></tr>");
			while(rs.next()) {
				out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
			}
			out.println("</table>");
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
