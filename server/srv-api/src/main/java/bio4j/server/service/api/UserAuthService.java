package bio4j.server.service.api;

public interface UserAuthService
{
    boolean login(String name, String password);
    boolean register(String name, String password);
}
