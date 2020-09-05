package task5.messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 2 c)
public class ConnectedClientsListResponse implements ServerMessage {
    public final ArrayList<String> clients;

    public ConnectedClientsListResponse(ArrayList<String> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectedClientsListResponse that = (ConnectedClientsListResponse) o;
        return Objects.equals(clients, that.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clients);
    }
}
