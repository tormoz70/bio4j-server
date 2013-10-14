package bio4j.server.service.dbsession.provider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import bio4j.server.api.services.DatabaseProvider;


public class Activator implements BundleActivator {
	private ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
        this.serviceRegistration = context.registerService(DatabaseProvider.class.getName(), new DatabaseProviderImpl(), null);
	}

	public void stop(BundleContext context) throws Exception {
		this.serviceRegistration.unregister();
	}

}
