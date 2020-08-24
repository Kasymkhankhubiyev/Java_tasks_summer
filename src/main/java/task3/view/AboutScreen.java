package task3.view;

import task3.model.Model;

import javax.swing.*;

public class AboutScreen extends AbstractScreen {
    private JLabel label = new JLabel("Some words about this tetris");
    private final JButton toMenuButton = new JButton("Main menu");

    public AboutScreen(TetrisView tetrisView) {
        super(tetrisView);
        toMenuButton.addActionListener(e -> tetrisView.showMenu());
        add(label);
        add(toMenuButton);
    }


    @Override
    protected void refresh(Model model) {
    }
}
