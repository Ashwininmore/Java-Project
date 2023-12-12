import java.io.IOException;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StrCookieServlet")
public class StrCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		Cookie c1=new Cookie("Desc", s1);
		Cookie c2=new Cookie("Qty", s2);
		response.addCookie(c1);
		response.addCookie(c2);
		out.println("Values stored in cookies");
		out.println("<a href='GetCookieServlet'>Get Data</a>");
		RequestDispatcher rd=request.getRequestDispatcher("itemCookie.html");
		rd.include(request, response);
		
		
		out.println("</body></html>");
		out.close();
		
	}

}
