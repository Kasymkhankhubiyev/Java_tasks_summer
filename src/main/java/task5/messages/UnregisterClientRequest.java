package task5.messages;

import java.util.Objects;

// 5 a)
public class UnregisterClientRequest implements ClientMessage{
    public final String sessionId;

    public UnregisterClientRequest(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnregisterClientRequest that = (UnregisterClientRequest) o;
        return Objects.equals(sessionId, that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId);
    }
}
