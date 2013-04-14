package bio4j.server.service.dbaccess;

import bio4j.server.service.api.DatabaseProvider;

public class DatabaseProviderImpl implements DatabaseProvider 
{
    public String login(String name, String password) {
    	return name + "/" + password;
    }
    public String register(String name, String password) {
    	return null;
    }
}
