package task5.messages;

import java.util.Objects;

//7 a)
public class ClientDisconnectedBroadcast implements ServerMessage {
    public final String username;

    public ClientDisconnectedBroadcast(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDisconnectedBroadcast that = (ClientDisconnectedBroadcast) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
