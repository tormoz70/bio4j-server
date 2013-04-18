package bio4j.server.service.api;

public interface SessionProvider
{
    String login(String name, String password);
    String register(String name, String password);
}
