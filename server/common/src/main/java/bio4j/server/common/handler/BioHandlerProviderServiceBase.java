package bio4j.server.common.handler;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bio4j.common.utils.Utl;
import bio4j.server.api.handlers.BioHandler;
import bio4j.server.api.helpers.BioHelper4HandlerMapper;
import bio4j.server.api.helpers.InjectHelper;
import bio4j.server.api.services.BioConfigService;
import bio4j.server.common.BioServiceBase;
import bio4j.server.common.config.BioConfigProps;
import bio4j.server.model.BioConfig;

public class BioHandlerProviderServiceBase extends BioServiceBase {
	private static Logger LOG;
	private BioConfig config;

	private static RequestHandler classIsHandler(Class<?> clazz) {
		return Utl.findAnnotation(RequestHandler.class, clazz);
	}
	
	public void registerHandler(String mapping, Class<?> handlerType) {
		
	}
	
	@InjectHelper
	private BioHelper4HandlerMapper helper;
	
	@Override
	protected void doOnInit() {
		Class<?> clazz = this.getClass();
		Bundle bundle = this.getBundleContext().getBundle();
		LOG = LoggerFactory.getLogger(clazz);
		LOG.debug("doOnInit - starts...");
		if(bundle != null) {
			String pkgName = clazz.getPackage().getName();
			LOG.debug("Register handlers of package {" + pkgName + "}: ");
			
			List<Class<?>> clazzes = Utl.findClassesOfBandle(this.getBundleContext());
			LOG.debug("Found types: " + clazzes.size());
			for(Class<?> c : clazzes){
				RequestHandler rh = classIsHandler(c); 
				if((rh != null) && (BioHandler.class.isAssignableFrom(c))) {
					this.registerHandler(rh.mapping(), c);
					LOG.debug(" --- REGISTRED. Type [" + c + "] registred as handler? and mapped on \"" + rh.mapping() + "\"");
				} else 
					LOG.debug(" --- SKIPED. type [" + c + "] is not handler!");
			}
		} else
			LOG.error("Reference on owner Bundle is null!");
		LOG.debug("doOnInit - ends.");
	}

	public BioConfig getCurrentConfig() {
		return this.config;
	}
}
