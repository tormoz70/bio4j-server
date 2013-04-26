package bio4j.server.http;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
	private void fireEvent_REGISTERED(BundleContext context, ServiceListener serviceListiner, String filter) throws InvalidSyntaxException {
		ServiceReference[] lst = context.getServiceReferences(null, filter);
		for (int i = 0; lst != null && i < lst.length; i++) {
			final ServiceReference sr = lst[i];
			serviceListiner.serviceChanged(new ServiceEvent(ServiceEvent.REGISTERED, sr));
		}
	}

	public void start(BundleContext context) throws Exception {
		AnServiceListener listener = new AnServiceListener();
		String serviceFilter = "(objectclass=bio4j.server.service.*)";
		context.addServiceListener(listener, serviceFilter);
		System.out.println("added ServiceListener for serviceFilter: " + serviceFilter);
		fireEvent_REGISTERED(context, listener, serviceFilter);
	}

	public void stop(BundleContext context) throws Exception {
	}

	private class AnServiceListener implements ServiceListener {
		public void serviceChanged(ServiceEvent serviceEvent) {
			ServiceReference sr = serviceEvent.getServiceReference();
			final int eventType = serviceEvent.getType();
			switch (eventType) {
			case ServiceEvent.UNREGISTERING: {
				System.out.println("Event 'UNREGISTERING'(" + eventType + ") for service " + "[" + sr + "] is  fired");
			}
				break;
			case ServiceEvent.REGISTERED: {
				System.out.println("Event 'REGISTERED' (" + eventType + ") for service " + "[" + sr + "] is  fired");

			}
				break;
			default:
				break;
			}
		}
	};
}
