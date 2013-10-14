package bio4j.server.service.security;

import bio4j.server.model.User;
import bio4j.server.api.services.UserAuthService;

public class UserAuthServiceImpl implements UserAuthService 
{
    public User login(String namepwdPair) {
    	return new User();
    }
}
