package bio4j.server.service.api;

import bio4j.server.model.User;

public interface UserAuthService
{
	User login(String namepwdPair);
}
