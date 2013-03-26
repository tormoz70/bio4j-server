package bio4j.server.httpHandler;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

//	BundleContext bctx;
//	ServiceTracker tracker;
//
//	private class UserAuthServiceTracker extends ServiceTracker {
//		UserAuthServiceTracker() {
//			super(bctx, UserAuthService.class.getName(), null);
//		}
//
//		@Override
//		public Object addingService(ServiceReference reference) {
//			UserAuthService service = (UserAuthService) context
//					.getService(reference);
//			service.register("foo", "bar");
//			service.register("sun", "oracle");
//			service.register("felix", "equinox");
//			return service;
//		}
//
//	}

	public void start(BundleContext context) throws Exception {
//		this.bctx = context;
//		tracker = new UserAuthServiceTracker();
//		tracker.open();
	}

	public void stop(BundleContext context) throws Exception {
//        tracker.close();
//        tracker = null; 
	}

}
