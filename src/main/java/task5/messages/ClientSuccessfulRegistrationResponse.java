package task5.messages;

import java.util.Objects;

// 1 c)
public class ClientSuccessfulRegistrationResponse implements ServerMessage {
    public final String sessionId;

    public ClientSuccessfulRegistrationResponse(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientSuccessfulRegistrationResponse that = (ClientSuccessfulRegistrationResponse) o;
        return Objects.equals(sessionId, that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId);
    }
}
