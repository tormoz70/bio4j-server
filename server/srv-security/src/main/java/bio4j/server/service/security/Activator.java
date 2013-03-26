package bio4j.server.service.security;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {
	private ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
        this.serviceRegistration = context.registerService(UserAuthService.class.getName(), new UserAuthServiceImpl(), null);
//		this.bctx = context;
//		tracker = new UserAuthServiceTracker();
//		tracker.open();
	}

	public void stop(BundleContext context) throws Exception {
		this.serviceRegistration.unregister();
//		tracker.close();
//		tracker = null;
	}

//	private class UserAuthServiceTracker extends ServiceTracker {
//		UserAuthServiceTracker() {
//			super(bctx, UserAuthService.class.getName(), null);
//		}
//
//		@Override
//		public Object addingService(ServiceReference reference) {
//			UserAuthService service = (UserAuthService) context.getService(reference);
//			service.register("foo", "bar");
//			service.register("sun", "oracle");
//			service.register("felix", "equinox");
//			return service;
//		}
//
//	}
}
