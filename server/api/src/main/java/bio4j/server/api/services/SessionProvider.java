package bio4j.server.api.services;

import javax.servlet.http.HttpSession;

public interface SessionProvider {
    void register(String sessionId, HttpSession session);
}
