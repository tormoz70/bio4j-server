package bio4j.server.common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.BundleContext;

import bio4j.server.api.BioEnvironment;
import bio4j.server.api.Delegate;
import bio4j.server.api.services.BioService;



public abstract class BioServiceBase implements BioService {

	private BioEnvironment environment;
	private BundleContext bundleContext;
	
	@Override
	public void init(BundleContext bundleContext, BioEnvironment environment) {
		this.environment = environment; 
		this.bundleContext = bundleContext;
		this.doOnInit();
	}

	@Override
	public BioEnvironment getEnvironment() {
		return this.environment;
	}

	@Override
	public BundleContext getBundleContext() {
		return this.bundleContext;
	}
	
	protected void doOnInit() {
	}
	
}
