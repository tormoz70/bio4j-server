package bio4j.server.biosrv;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import bio4j.server.service.api.BioEnvironment;
import bio4j.server.service.api.BioSrvHandler;
import bio4j.server.service.api.BioService;
import bio4j.server.service.base.BioRequestType;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/srv")
public class BioSrvServlet extends HttpServlet {

    /// <summary>
    /// для get запросов из сторонних приложений
    /// </summary>
    private final String csRequestTypeParamName = "rqtp";
    private final String csBioCodeParamName = "rqbc";
    private final String csQParamName = "rqpckt";
	
	// Данный сервлет обрабатывает запросы Bio
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		BioRequestType rqType = BioRequestType.Unassigned;
		try {
			//HttpSession session = req.getSession();
			BundleContext bundleContext = (BundleContext) getServletContext().getAttribute("osgi-bundlecontext");
			//Bundle bundle = bundleContext.getBundle();
			BioEnvironment bioEnvironment = null;
			ServiceReference sr = bundleContext.getServiceReference(BioSrvHandler.class.getName());
			if(sr != null) {
				BioService srv = (BioService)bundleContext.getService(sr);
				if(srv != null)
					bioEnvironment = srv.getEnvironment();
			}
	
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<HTML> <HEAD> <TITLE> Login " + ((bioEnvironment != null) ? bioEnvironment.getSystemName() : "Err")
					+ "</TITLE> </HEAD> <BODY BGCOLOR=white>");
	
			try {
				out.println("OK");
				
			} catch (Exception e) {
				out.println("Error:"+e.toString());
			}
			out.println("</BODY> </HTML> ");
		} catch(Exception ex) {
			
		}
	}
}
