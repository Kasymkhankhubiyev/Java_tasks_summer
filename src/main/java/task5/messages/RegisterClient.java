package task5.messages;

import java.util.Objects;

public class RegisterClient implements ClientMessage{
    public final String userName;
    public final String chatClientName;

    public RegisterClient(String userName, String chatClientName) {
        this.userName = userName;
        this.chatClientName = chatClientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterClient that = (RegisterClient) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(chatClientName, that.chatClientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, chatClientName);
    }
}
