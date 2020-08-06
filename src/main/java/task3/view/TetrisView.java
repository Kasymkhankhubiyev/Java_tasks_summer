package task3.view;

import task3.model.Model;
import task3.model.ModelState;
import task3.model.View;

import javax.swing.*;
import java.awt.*;

public class TetrisView implements View {
    private final Model model;
    private final JFrame frame = new JFrame("Tetris");
    private final JPanel root = new JPanel();
    private final JLabel label = new JLabel("AAABBB");


    public TetrisView(Model model) {
        init();
        this.model = model;
        model.setView(this);
    }

    private void init(){
        frame.setPreferredSize(new Dimension(400, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(root);

        root.add(label);
    }

    @Override
    public void updateView(ModelState modelState) {

    }

    public void start(){
        frame.pack();
        frame.setVisible(true);
    }
}
