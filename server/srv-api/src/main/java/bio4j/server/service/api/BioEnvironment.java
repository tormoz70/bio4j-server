package bio4j.server.service.api;


public interface BioEnvironment {
	void init();
	String getSystemName();
	void registerService(BioService service);
	SessionProvider getSessionProvider();
}
