package bio4j.server.service.security;

import bio4j.server.service.api.UserAuthService;

public class UserAuthServiceImpl implements UserAuthService 
{
    public boolean login(String name, String password) {
    	return true;
    }
    public boolean register(String name, String password) {
    	return true;
    }
}
