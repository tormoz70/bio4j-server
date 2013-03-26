package bio4j.server.service.security;

public interface UserAuthService
{
    boolean login(String name, String password);
    boolean register(String name, String password);
}
