package bio4j.server.api.services;

public interface DatabaseProvider
{
    String login(String name, String password);
    String register(String name, String password);
}
