package bio4j.server.service.session;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import bio4j.server.service.api.SessionProvider;

public class Activator implements BundleActivator {
	public static Logger LOG;
	private ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("start...");
		LOG = Logger.getLogger(Activator.class);
		System.out.println("1-Logger getted");
		//DOMConfigurator.configure("c:\\glassfish3\\glassfish\\domains\\domain1\\config\\log4j.xml");
		
		DOMConfigurator.configure("/log4j.xml");
		//BasicConfigurator.configure();
		System.out.println("2-Logger configured");
		LOG.debug("Init...");
		System.out.println("3-Logger writed debug");
		this.serviceRegistration = context.registerService(SessionProvider.class.getName(), new SessionProviderImpl(), null);
		LOG.debug("Init-done");
		System.out.println("start-out");
	}

	public void stop(BundleContext context) throws Exception {
		this.serviceRegistration.unregister();
	}

}
