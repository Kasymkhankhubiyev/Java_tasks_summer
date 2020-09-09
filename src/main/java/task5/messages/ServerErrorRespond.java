package task5.messages;

import java.util.Objects;

//1 b), 2 b), 3 b), 5 b)
public class ServerErrorRespond implements ServerMessage{
    public final String message;

    public ServerErrorRespond(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerErrorRespond that = (ServerErrorRespond) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
