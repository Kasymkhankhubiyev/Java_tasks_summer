package task5.messages;

import java.util.Objects;

public class NewClientConnected implements ServerMessage{
    public final String username;

    public NewClientConnected(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewClientConnected that = (NewClientConnected) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
