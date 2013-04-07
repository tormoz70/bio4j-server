package bio4j.server.service.security;

import bio4j.server.service.api.UserAuthService;

public class UserAuthServiceImpl implements UserAuthService 
{
    public String login(String name, String password) {
    	return name + "/" + password;
    }
    public String register(String name, String password) {
    	return null;
    }
}
