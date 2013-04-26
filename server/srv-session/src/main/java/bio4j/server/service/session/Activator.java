package bio4j.server.service.session;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import bio4j.server.service.api.SessionProvider;

public class Activator implements BundleActivator {
	public static Logger LOG;
	private ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
		LOG = Logger.getLogger(Activator.class);
		LOG.debug("Init...");
		this.serviceRegistration = context.registerService(SessionProvider.class.getName(), new SessionProviderImpl(), null);
		LOG.debug("Init-done");
	}

	public void stop(BundleContext context) throws Exception {
		this.serviceRegistration.unregister();
	}

}
