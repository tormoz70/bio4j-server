package bio4j.server.root;

import bio4j.server.service.api.BioService;
import bio4j.server.service.api.BioEnvironment;
import bio4j.server.service.api.SessionProvider;

public class EnvironmentImpl implements BioEnvironment {

	private final static BioEnvironment instance = new EnvironmentImpl();  
	
	public static BioEnvironment getInstance(){
		return instance;
	} 
	
	@Override
	public String getSystemName() {
		return "Bio4j";
	}

	private SessionProvider sessionProvider;
	@Override
	public SessionProvider getSessionProvider() {
		return this.sessionProvider;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerService(BioService service) {
		if(service instanceof SessionProvider)
			this.sessionProvider = (SessionProvider)service;
	}

	
}
