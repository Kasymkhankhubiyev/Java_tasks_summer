package task3;

import task3.model.Model;
import task3.model.ModelImpl;
import task3.view.TetrisView;

public class Main {

    public static void main(String[] args) {
        Model model = new ModelImpl();

        TetrisView tetrisView = new TetrisView(model);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                tetrisView.start();
            }
        });
    }


}
