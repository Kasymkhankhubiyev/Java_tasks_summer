package task5.messages;

import java.util.Objects;

public class ServerErrorAnswer implements ServerMessage{
    public final String message;

    public ServerErrorAnswer(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerErrorAnswer that = (ServerErrorAnswer) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
