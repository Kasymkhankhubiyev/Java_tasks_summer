package task5.messages;

import java.util.Objects;

// 4 a)
public class MessageBroadcast implements ServerMessage{
    public final String message;
    public final String chatNameFrom;

    public MessageBroadcast(String message, String chatNameFrom) {
        this.message = message;
        this.chatNameFrom = chatNameFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageBroadcast that = (MessageBroadcast) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(chatNameFrom, that.chatNameFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, chatNameFrom);
    }
}
