import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/StrSessionServlet")
public class StrSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		HttpSession session=request.getSession();
		session.setAttribute("uid", s1);
		session.setAttribute("pwd", s2);
		out.println("Values stored in session");
		out.println("<a href='GetSeesionServlet'>Get data<a/>");
		out.println("</body></html>");
		out.close();
	}

}
