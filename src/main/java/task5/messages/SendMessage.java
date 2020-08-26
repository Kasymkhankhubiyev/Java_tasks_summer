package task5.messages;

import java.util.Objects;

public class SendMessage implements ClientMessage{
    public final String message;
    public final String sessionId;

    public SendMessage(String message, String sessionId) {
        this.message = message;
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SendMessage that = (SendMessage) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(sessionId, that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, sessionId);
    }
}
