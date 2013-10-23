package bio4j.server.root;

import bio4j.server.api.BioEnvironment;
import bio4j.server.api.services.BioService;
import bio4j.server.api.services.DatabaseProvider;
import bio4j.server.api.services.SessionProvider;
import bio4j.server.api.services.UserAuthService;

public class EnvironmentImpl implements BioEnvironment {

	private final static BioEnvironment instance = new EnvironmentImpl();  
	
	public static BioEnvironment getInstance(){
		return instance;
	} 
	
	@Override
	public String getSystemName() {
		return "Bio4j";
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerService(BioService service) {
		if(service instanceof SessionProvider)
			this.sessionProvider = (SessionProvider)service;
		if(service instanceof UserAuthService)
			this.userAuthService = (UserAuthService)service;
		if(service instanceof DatabaseProvider)
			this.databaseProvider = (DatabaseProvider)service;
	}


	private SessionProvider sessionProvider;
	@Override
	public SessionProvider getSessionProvider() {
		return this.sessionProvider;
	}

	private UserAuthService userAuthService;
	@Override
	public UserAuthService getUserAuthService() {
		return this.userAuthService;
	}
	
	private DatabaseProvider databaseProvider;
	@Override
	public DatabaseProvider getDatabaseProvider() {
		return this.databaseProvider;
	}
	
}
