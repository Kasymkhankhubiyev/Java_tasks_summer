package task5.client.model;

import java.util.List;

public interface ClientView {
    void setClientModel(ClientModel clientModel);
    void connectedToServer(String host, int port, String username);
    void disconnectedFromServer();
    void showError(String error);
    void newMessage(String from, String message);
    void updateConnectedUsers(List<String> users);
    void saveFile(String username, String fileName, byte[] data);
}
