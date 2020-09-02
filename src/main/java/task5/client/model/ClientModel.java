package task5.client.model;

public interface ClientModel {
    void setClientView(ClientView clientView);
    void connectToServer(String host, int port, String username);
    void disconnectFromServer();
    void sendMessage(String message);
}
