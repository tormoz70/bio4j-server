package bio4j.server.service.dbaccess;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import bio4j.server.service.api.DatabaseProvider;
import bio4j.server.service.api.UserAuthService;


public class Activator implements BundleActivator {
	private ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
        this.serviceRegistration = context.registerService(DatabaseProvider.class.getName(), new SessionProviderImpl(), null);
	}

	public void stop(BundleContext context) throws Exception {
		this.serviceRegistration.unregister();
	}

}
