package task5.messages;

import java.util.Objects;

//3 a)
public class SendMessageRequest implements ClientMessage{
    public final String message;
    public final String sessionId;

    public SendMessageRequest(String message, String sessionId) {
        this.message = message;
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SendMessageRequest that = (SendMessageRequest) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(sessionId, that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, sessionId);
    }
}
