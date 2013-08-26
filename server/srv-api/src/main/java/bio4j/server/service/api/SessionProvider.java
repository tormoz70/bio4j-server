package bio4j.server.service.api;

import javax.servlet.http.HttpSession;

public interface SessionProvider {
    void register(String sessionId, HttpSession session);
}
