import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetSeesionServlet")
public class GetSeesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		HttpSession session=request.getSession();
		String s1=(String)session.getAttribute("uid");
		String s2=(String)session.getAttribute("pwd");
		out.println("UsrrId:"+s1);
		out.println("Password:"+s2);
		out.println("</body></html>");
		out.close();
	}
}
