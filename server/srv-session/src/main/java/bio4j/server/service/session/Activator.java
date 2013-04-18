package bio4j.server.service.session;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import bio4j.server.service.api.SessionProvider;


public class Activator implements BundleActivator {
	private ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
        this.serviceRegistration = context.registerService(SessionProvider.class.getName(), new SessionProviderImpl(), null);
	}

	public void stop(BundleContext context) throws Exception {
		this.serviceRegistration.unregister();
	}

}
