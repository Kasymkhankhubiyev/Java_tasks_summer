package task5.messages;

import java.util.Objects;

public class ClientDeleted implements ServerMessage {
    public final String sessionId;

    public ClientDeleted(String sessionId) {
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
