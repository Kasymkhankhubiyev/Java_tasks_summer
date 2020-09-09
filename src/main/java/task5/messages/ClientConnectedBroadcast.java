package task5.messages;

import java.util.Objects;

//6 a)
public class ClientConnectedBroadcast implements ServerMessage{
    public final String username;

    public ClientConnectedBroadcast(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientConnectedBroadcast that = (ClientConnectedBroadcast) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
