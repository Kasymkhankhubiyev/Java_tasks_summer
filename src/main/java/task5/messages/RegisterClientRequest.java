package task5.messages;

import java.io.IOException;
import java.util.Objects;

//1 a)
public class RegisterClientRequest implements ClientMessage{
    public final String userName;
    public final String chatClientName;

    public RegisterClientRequest(String userName, String chatClientName) throws IOException {
        this.userName = userName;
        this.chatClientName = chatClientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterClientRequest that = (RegisterClientRequest) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(chatClientName, that.chatClientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, chatClientName);
    }
}
