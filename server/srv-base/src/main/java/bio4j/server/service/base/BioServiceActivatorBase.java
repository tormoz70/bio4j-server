package bio4j.server.service.base;

import java.lang.reflect.ParameterizedType;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import bio4j.server.service.api.BioService;

public class BioServiceActivatorBase<T extends BioServiceBase> implements BundleActivator {
	public static Logger LOG;
	
	private ServiceRegistration serviceRegistration;
	private Class<?> serviceClass;

	public void start(BundleContext context) throws Exception {
		this.serviceClass = (Class<?>)((ParameterizedType)this.getClass().
			       getGenericSuperclass()).getActualTypeArguments()[0];
		LOG = Logger.getLogger(this.serviceClass);
		BioServiceBase newService = (BioServiceBase)this.serviceClass.newInstance();
		Class<?>[] intfs = newService.getClass().getInterfaces();
		for (Class<?> intf : intfs) 
			if(intf != BioService.class){
				// регистрируем первый попавшийся интерфейс не BioService 
				this.serviceRegistration = context.registerService(intf.getName(), newService, null);
				LOG.debug("Service ["+this.serviceClass.getName()+"] - registred as "+intf.getName());
				break;
			}
		LOG.debug("Service ["+this.serviceClass.getName()+"] - started");
	}

	public void stop(BundleContext context) throws Exception {
		this.serviceRegistration.unregister();
		LOG.debug("Service ["+this.serviceClass.getName()+"] - stopped");
	}

}
