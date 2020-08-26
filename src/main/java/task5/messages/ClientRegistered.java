package task5.messages;

import java.util.Objects;

public class ClientRegistered implements ServerMessage {
    public final String sessionId;

    public ClientRegistered(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientRegistered that = (ClientRegistered) o;
        return Objects.equals(sessionId, that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId);
    }
}
