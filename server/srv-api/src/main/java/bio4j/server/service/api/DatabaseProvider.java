package bio4j.server.service.api;

public interface DatabaseProvider
{
    String login(String name, String password);
    String register(String name, String password);
}
