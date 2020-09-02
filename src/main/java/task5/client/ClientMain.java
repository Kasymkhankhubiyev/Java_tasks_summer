package task5.client;

import task5.client.model.ClientView;
import task5.client.view.ClientViewImpl;

public class ClientMain {
    public static void main(String[] args) {
        ClientViewImpl clientView  = new ClientViewImpl();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                clientView.start();
            }
        });
    }
}
