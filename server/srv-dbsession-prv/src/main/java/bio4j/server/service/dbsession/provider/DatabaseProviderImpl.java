package bio4j.server.service.dbsession.provider;

import bio4j.server.api.services.DatabaseProvider;

public class DatabaseProviderImpl implements DatabaseProvider 
{
    public String login(String name, String password) {
    	return name + "/" + password;
    }
    public String register(String name, String password) {
    	return null;
    }
}
