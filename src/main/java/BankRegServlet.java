import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BankRegServlet")
public class BankRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mdj55","root","root");
			PreparedStatement stat=con.prepareStatement("insert into useraccount values(?,?,?,?,?,?)");
			stat.setString(1, request.getParameter("t1"));
			stat.setString(2, request.getParameter("t2"));
			stat.setString(3, request.getParameter("t3"));
			stat.setString(4, request.getParameter("t4"));
			stat.setString(5, request.getParameter("t5"));
			stat.setInt(6, Integer.parseInt(request.getParameter("t6")));
			
			stat.executeUpdate();
			out.println("<h2>Account Opened Successfully...</h2>");
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		out.println("</body></html>");
		out.close();
	}

}
