package bio4j.server.service.session;

import bio4j.server.service.api.SessionProvider;

public class SessionProviderImpl implements SessionProvider 
{
    public String login(String name, String password) {
    	return name + "/" + password;
    }
    public String register(String name, String password) {
    	return null;
    }
}
