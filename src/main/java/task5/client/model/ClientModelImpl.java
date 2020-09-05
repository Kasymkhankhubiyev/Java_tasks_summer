package task5.client.model;

import task5.messages.*;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.file.Files;
import java.util.List;

public class ClientModelImpl implements ClientModel {
    private ConnectionToServer connectionToServer = null;
    private String sessionId;
    private ClientView clientView;

    @Override
    public void setClientView(ClientView clientView) {
        this.clientView = clientView;
    }

    public void acceptMessage(ServerMessage serverMessage){
        if (serverMessage instanceof ClientSuccessfulRegistrationResponse){
            ClientSuccessfulRegistrationResponse clientRegistered = (ClientSuccessfulRegistrationResponse) serverMessage;
            sessionId = clientRegistered.sessionId;
            clientView.connectedToServer(connectionToServer.host, connectionToServer.port, connectionToServer.username);
        } else if (serverMessage instanceof ServerErrorRespond){
            clientView.showError(((ServerErrorRespond) serverMessage).message);
            if (sessionId == null) disconnectFromServer();
        } else if (serverMessage instanceof MessageBroadcast){
            MessageBroadcast messageBroadcast = (MessageBroadcast) serverMessage;
            clientView.newMessage(messageBroadcast.chatNameFrom, messageBroadcast.message);
        } else if (serverMessage instanceof ClientConnectedBroadcast) {
            String messageText = ((ClientConnectedBroadcast) serverMessage).username + " connected!";
            clientView.newMessage("Server", messageText);
            try {
                connectionToServer.objectOutputStream.writeObject(new ConnectedClientsListRequest(sessionId));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (serverMessage instanceof ClientDisconnectedBroadcast) {
            String messageText = ((ClientDisconnectedBroadcast) serverMessage).username + " disconnected!";
            clientView.newMessage("Server", messageText);
            try {
                connectionToServer.objectOutputStream.writeObject(new ConnectedClientsListRequest(sessionId));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (serverMessage instanceof ConnectedClientsListResponse) {
            List<String> users = ((ConnectedClientsListResponse) serverMessage).clients;
            clientView.updateConnectedUsers(users);
        } else if (serverMessage instanceof FileBroadcast) {
            FileBroadcast fileBroadcast = (FileBroadcast) serverMessage;
            clientView.saveFile(fileBroadcast.username, fileBroadcast.fileName, fileBroadcast.data);
        }
    }

    @Override
    public void connectToServer(String host, int port, String username) {
        disconnectFromServer();
        try {
            Socket socket = new Socket(host, port);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            connectionToServer =
                    new ConnectionToServer(host, port, username, socket, objectOutputStream);

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(connectionToServer.socket.getInputStream());
                        objectOutputStream.writeObject(new RegisterClientRequest(username, username));
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
                    disconnectFromServer();
                }
            };

            new Thread(runnable).start();

        } catch (ConnectException e) {
            clientView.showError(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnectFromServer() {
        if (connectionToServer != null) {
            try {
                try {
                    if (sessionId != null) {
                        connectionToServer.objectOutputStream.writeObject(new UnregisterClientRequest(sessionId));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                connectionToServer.socket.close();
                connectionToServer = null;
                sessionId = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        clientView.disconnectedFromServer();
    }

    @Override
    public void sendMessage(String message) {
        if (isConnected()){
            try {
                connectionToServer.objectOutputStream.writeObject(new SendMessageRequest(message, sessionId));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendFile(File file) {
        String filename = file.getName();
        byte[] data = null;
        try {
            data = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            clientView.showError("Unable to open a file");
        }
        if (data != null) {
            SendFileRequest sendFileRequest = new SendFileRequest(filename, data);
            try {
                connectionToServer.objectOutputStream.writeObject(sendFileRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isConnected() {
        return connectionToServer != null && sessionId != null;
    }
}
