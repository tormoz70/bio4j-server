package bio4j.server.api.services;

import bio4j.server.model.User;

public interface UserAuthService
{
	User login(String namepwdPair);
}
