package task5.client.model;

import task5.messages.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientModelImpl implements ClientModel {
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private String sessionId;

    private ClientView clientView;

    @Override
    public void setClientView(ClientView clientView) {
        this.clientView = clientView;
    }

    public void acceptMessage(ServerMessage serverMessage){
        if (serverMessage instanceof ClientRegistered){
            ClientRegistered clientRegistered = (ClientRegistered) serverMessage;
            sessionId = clientRegistered.sessionId;
            clientView.connectedToServer("0", 0, "abc");
            //TODO: fix this ^^
        } else if (serverMessage instanceof ServerErrorAnswer){
            //((ServerErrorAnswer) serverMessage)
        } else if (serverMessage instanceof MessageFromServer){

        }

    }

    @Override
    public void connectToServer(String host, int port, String username) {
        disconnectFromServer();
        try {
            socket = new Socket(host, port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                        while (true){
                            try {
                                Object object = objectInputStream.readObject();
                                if (object instanceof ServerMessage){
                                    acceptMessage((ServerMessage) object);
                                }
                            } catch (ClassNotFoundException e) {}
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sessionId = null;
                    socket = null;
                }
            };

            new Thread(runnable).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnectFromServer() {
        if (socket != null) {
            try {
                socket.close();
                socket = null;
                sessionId = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendMessage(String message) {
        if (sessionId != null){
            try {
                objectOutputStream.writeObject(new SendMessage(message, sessionId));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
