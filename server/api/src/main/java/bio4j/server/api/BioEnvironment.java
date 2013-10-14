package bio4j.server.api;

import bio4j.server.api.services.BioService;
import bio4j.server.api.services.SessionProvider;


public interface BioEnvironment {
	void init();
	String getSystemName();
	void registerService(BioService service);
	SessionProvider getSessionProvider();
}
