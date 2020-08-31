package task5.messages;

import java.util.Objects;

public class ServerSuccessAnswer implements ServerMessage{
    public final String message;

    public ServerSuccessAnswer(String message){
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerSuccessAnswer that = (ServerSuccessAnswer) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

}
