package task5.client;

public class Client {
    private final String clientName;
    private final String clientChatName;
    private final String clientSessionId;

    public Client(String clientName, String clientChatName, String clientSessionId){
        this.clientName = clientName;
        this.clientChatName = clientChatName;
        this.clientSessionId = clientSessionId;
    }

    public String getClientName(){
        return clientName;
    }

    public String getClientChatName(){
        return clientChatName;
    }

    public String getClientSessionId(){
        return clientSessionId;
    }
}

