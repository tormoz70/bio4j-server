package bio4j.server.service.srvc;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import bio4j.server.api.BioEnvironment;
import bio4j.server.api.services.BioService;
import bio4j.server.api.services.BioSrvcService;
import bio4j.server.common.BioRequestType;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/srv")
public class BioSrvcServlet extends HttpServlet {
	public static Logger LOG = Logger.getLogger(BioSrvcServlet.class);

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
			BundleContext bundleContext = (BundleContext) getServletContext().getAttribute("osgi-bundlecontext");
			BioEnvironment bioEnvironment = null;
			ServiceReference sr = bundleContext.getServiceReference(BioSrvcService.class.getName());
			LOG.debug("ServiceReference of "+BioSrvcService.class+" : "+sr);
			if(sr != null) {
				BioService srv = (BioService)bundleContext.getService(sr);
				LOG.debug("BioService srv : "+srv);
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
