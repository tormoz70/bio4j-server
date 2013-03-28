package bio4j.server.httpHandler;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;


@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -868536249619464021L;

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		BundleContext bundleContext = (BundleContext) getServletContext().getAttribute("osgi-bundlecontext");
		Bundle bandle = bundleContext.getBundle();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<HTML> <HEAD> <TITLE> Login "
				+ "</TITLE> </HEAD> <BODY BGCOLOR=white>");

		String name = req.getParameter("name");
		String password = req.getParameter("password");
		try {
			//this.testEJB.login("test-user", "test-pwd");
			out.println("OK-1!!!!!; bandle: " + (bandle != null ? bandle.toString() : "null"));
		} catch (Exception e) {
			out.println("Error:"+e.toString());
		}
		out.println("</BODY> </HTML> ");

	}
}
