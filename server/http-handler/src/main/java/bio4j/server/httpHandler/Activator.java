package bio4j.server.httpHandler;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

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
	
	public void start(BundleContext context) throws Exception {
//		UserAuthServiceListener listener = new UserAuthServiceListener();
//        String serviceFilter = "(objectclass=" + UserAuthService.class.getName() + ")";
//        context.addServiceListener(listener, serviceFilter);
//        fireEvent_REGISTERED(context, listener, serviceFilter);
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
