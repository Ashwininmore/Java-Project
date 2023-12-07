import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetBalServlet")
public class GetBalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mdj55","root","root");
			PreparedStatement stat=con.prepareStatement("select bal from useraccount where accno=?");
			stat.setString(1, request.getParameter("t3"));
			
			ResultSet rs=stat.executeQuery();
			if(rs.next()) {
				out.println("<center><h1>Your Balance is:"+rs.getInt(1));
			}
			else {
				out.println("Account no. is not Found!!");
			}
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
