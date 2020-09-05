package task5.client;

import task5.client.model.ClientModelImpl;
import task5.client.model.ClientView;
import task5.client.view.ClientViewImpl;

public class ClientMain {
    public static void main(String[] args) {
        ClientViewImpl clientView  = new ClientViewImpl();
        ClientModelImpl clientModel = new ClientModelImpl();

        clientModel.setClientView(clientView);
        clientView.setClientModel(clientModel);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                clientView.start();
            }
        });
    }
}
