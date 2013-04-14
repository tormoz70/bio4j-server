package bio4j.server.httpHandler;

import javax.servlet.http.HttpServlet;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;

import bio4j.server.service.api.UserAuthService;

public class Activator implements BundleActivator {

	private void fireEvent_REGISTERED(BundleContext context,
            ServiceListener serviceListiner, String filter)
            throws InvalidSyntaxException {
      ServiceReference[] lst 
         = context.getServiceReferences(null, filter);
        for (int i = 0; lst != null && i < lst.length; i++) {
            final ServiceReference sr = lst[i];
            serviceListiner.serviceChanged(
                    new ServiceEvent(
                        ServiceEvent.REGISTERED, sr));
        }
    }
	
	private LoginServlet loginServlet;
	
	public void start(BundleContext context) throws Exception {
		
//		ServiceReference sr  =  context.getServiceReference(HttpService.class.getName());
//		System.out.println("bio4j.server.httpHandler.Activator - 1");
//		if(sr != null) {
//			System.out.println("bio4j.server.httpHandler.Activator - 2");
//			HttpService httpService = (HttpService)context.getService(sr);
//			if(httpService != null) {
//				System.out.println("bio4j.server.httpHandler.Activator - 3");
//				HttpContext httpContext = httpService.createDefaultHttpContext();
//				this.loginServlet = new LoginServlet();
//				this.loginServlet.setSrvName("FTW-Servlet");
//				httpService.registerServlet("/login", this.loginServlet, null, httpContext);
//				System.out.println("bio4j.server.httpHandler.Activator - 4");
//			}
//		}
		
		UserAuthServiceListener listener = new UserAuthServiceListener();
		String serviceFilter = "(objectclass=" + UserAuthService.class.getName() + ")";
		context.addServiceListener(listener, serviceFilter);
		fireEvent_REGISTERED(context, listener, serviceFilter);
	}

	public void stop(BundleContext context) throws Exception {
	}

	private class UserAuthServiceListener implements ServiceListener{
	      public void serviceChanged(ServiceEvent serviceEvent) {
	        ServiceReference sr = serviceEvent.getServiceReference();
	            final int eventType = serviceEvent.getType();
	            switch (eventType) {
	                case ServiceEvent.UNREGISTERING: {
	                    System.out.println("Event 'UNREGISTERING'("
	                            + eventType + ") for service " +
	                            "["+ sr+ "] is  fired");
	                }
	                break;
	                case ServiceEvent.REGISTERED: {
	                    System.out.println("Event 'REGISTERED' (" 
	                            + eventType + ") for service " +
	                            "["+ sr+ "] is  fired");
	                    
	                    Bundle bundle = sr.getBundle();
//	                    UserAuthService timeService = 
//	                        (UserAuthService)bundle
//	                        .getBundleContext()
//	                        .getService(sr);
//	                    wsTimeServerImpl.setTimeService(timeService);
	                }
	                break;
	            default:
	                break;
	            }
	        }
	    };	
}
