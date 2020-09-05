package task5.messages;

import java.util.Objects;

//2 a
public class ConnectedClientsListRequest implements ClientMessage{
    final String sessionId;

    public ConnectedClientsListRequest(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectedClientsListRequest that = (ConnectedClientsListRequest) o;
        return Objects.equals(sessionId, that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId);
    }
}
