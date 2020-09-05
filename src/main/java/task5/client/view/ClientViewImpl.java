package task5.client.view;

import net.miginfocom.swing.MigLayout;
import task5.client.model.ClientModel;
import task5.client.model.ClientView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ClientViewImpl implements ClientView {
    private ClientModel clientModel;
    private final JFrame frame = new JFrame("Chat");
    private final JPanel root = new JPanel(new MigLayout("fill"));

    private final JButton connectButton = new JButton("Connect");
    private final JButton disconnectButton = new JButton("Disconnect");
    private final JLabel hostLabel = new JLabel("Host");
    private final JLabel portLabel = new JLabel("Port");
    private final JLabel usernameLabel = new JLabel("Username");
    private final JTextField hostTextField = new JTextField("127.0.0.1");
    private final JTextField portTextField = new JTextField("6666");
    private final JTextField usernameTextField = new JTextField("User1");

    private final JLabel usersListLabel = new JLabel("Users");
    private final JList<String> usersList = new JList<>();

    private final JEditorPane messagesArea = new JEditorPane();
    private final JEditorPane newMessageArea = new JEditorPane();
    private final JButton sendButton = new JButton("Send");

    private final JButton sendFileButton = new JButton("Send file");


    public ClientViewImpl() {
        Border border = BorderFactory.createMatteBorder(1,1,1,1, Color.darkGray);

        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.setResizable(false);

        JPanel loginPanel = new JPanel(new MigLayout());
        loginPanel.add(hostLabel);
        loginPanel.add(hostTextField, "wrap, growx");
        loginPanel.add(portLabel);
        loginPanel.add(portTextField, "wrap, growx");
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField, "wrap, growx");
        loginPanel.add(connectButton, "spanx, split 2, sg button");
        loginPanel.add(disconnectButton, "wrap, sg button");

        JScrollPane usersListScrollPane = new JScrollPane(usersList);

        root.add(loginPanel);
        root.add(messagesArea, "spanx 2, spany 3, wrap, grow, pushx");
        root.add(usersListLabel, "wrap");
        root.add(usersListScrollPane, "wrap, pushy, grow, w 10:10:max");
        root.add(sendFileButton);
        root.add(newMessageArea, "grow");
        root.add(sendButton);


        loginPanel.setBorder(border);
        messagesArea.setBorder(border);
        newMessageArea.setBorder(border);
        usersListScrollPane.setBorder(border);

        connectButton.addActionListener(e ->
                clientModel.connectToServer(hostTextField.getText(),
                        Integer.parseInt(portTextField.getText()),
                        usernameTextField.getText())              );

        disconnectButton.addActionListener(e -> {
            clientModel.disconnectFromServer();
        });

        sendButton.addActionListener(e ->{
                    clientModel.sendMessage(newMessageArea.getText());
                    newMessageArea.setText("");
                });

        sendFileButton.addActionListener(e -> sendFile());

        disconnectedFromServer();
    }

    private void sendFile(){
        JFileChooser fc = new JFileChooser();
        int response = fc.showOpenDialog(frame);
        if (response == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            clientModel.sendFile(f);
        }
    }

    public void start(){
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    @Override
    public void connectedToServer(String host, int port, String username) {
        SwingUtilities.invokeLater(() -> {
            usernameTextField.setEnabled(false);
            usernameTextField.setText(username);
            portTextField.setEnabled(false);
            portTextField.setText("" + port);
            hostTextField.setEnabled(false);
            hostTextField.setText(host);
            disconnectButton.setEnabled(true);
            connectButton.setEnabled(false);
            usersList.setEnabled(true);
            messagesArea.setEnabled(true);
            sendButton.setEnabled(true);
            newMessageArea.setEnabled(true);
            usersList.setListData(new String[]{});
            messagesArea.setText("");
        });
    }

    @Override
    public void disconnectedFromServer() {
        SwingUtilities.invokeLater(() -> {
            usernameTextField.setEnabled(true);
            portTextField.setEnabled(true);
            hostTextField.setEnabled(true);
            disconnectButton.setEnabled(false);
            connectButton.setEnabled(true);
            usersList.setEnabled(false);
            usersList.setListData(new String[]{});
            messagesArea.setText("");
            messagesArea.setEnabled(false);
            sendButton.setEnabled(false);
            newMessageArea.setEnabled(false);
        });
    }

    @Override
    public void showError(String error) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showConfirmDialog(frame, error,
                    "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        });
    }

    @Override
    public void newMessage(String from, String message) {
        SwingUtilities.invokeLater(() -> {
            String messageText = from + ": " + message;
            messagesArea.setText(messagesArea.getText() + System.lineSeparator() + messageText);
        });
    }

    @Override
    public void updateConnectedUsers(List<String> users) {
        SwingUtilities.invokeLater(() -> {
            usersList.setListData(users.toArray(new String[]{}));
        });
    }

    @Override
    public void saveFile(String username, String fileName, byte[] data) {
        SwingUtilities.invokeLater(() -> {
            int answer = JOptionPane.showConfirmDialog(frame, "Receive file: " + fileName + " from " + username + "?",
                    "Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION){
                JFileChooser fc = new JFileChooser();
                fc.setSelectedFile(new File(fileName));
                int response = fc.showSaveDialog(frame);
                if (response == JFileChooser.APPROVE_OPTION){
                    File f = fc.getSelectedFile();
                    try {
                        Files.write(f.toPath(), data);
                    } catch (IOException e) {
                        showError("Unable to save a file!");
                    }
                }
            }
        });
    }
}
