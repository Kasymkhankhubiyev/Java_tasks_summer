package task5.client.model;

import java.io.File;

public interface ClientModel {
    void setClientView(ClientView clientView);
    void connectToServer(String host, int port, String username);
    void disconnectFromServer();
    void sendMessage(String message);
    void sendFile(File path);
}
