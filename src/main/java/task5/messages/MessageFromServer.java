package task5.messages;

import java.util.Objects;

public class MessageFromServer implements ServerMessage{
    public final String message;
    public final String chatNameFrom;

    public MessageFromServer(String message, String chatNameFrom) {
        this.message = message;
        this.chatNameFrom = chatNameFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageFromServer that = (MessageFromServer) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(chatNameFrom, that.chatNameFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, chatNameFrom);
    }
}
