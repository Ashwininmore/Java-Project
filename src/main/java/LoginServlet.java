

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String s1=request.getParameter("userId");
		String s2=request.getParameter("password");
		
		out.println("<html><body>");
		if(s1.equals("admin")&& s2.equals("admin"))
			out.println("<h1>Welcome "+s1+"</h1>");
		else
			out.println("<h1>Login Failed..</h1>");
		
		out.println("</body></html>");
		out.close();
//		doGet(request, response);
	}

}
