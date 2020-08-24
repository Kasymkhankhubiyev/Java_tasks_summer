package task3.view;

import task3.model.Model;

import javax.swing.*;

public class HighScoresScreen extends AbstractScreen {
    private final JList<Integer> list = new JList<>();
    private final JButton toMenuButton = new JButton("Main menu");

    public HighScoresScreen(TetrisView tetrisView) {
        super(tetrisView);
        toMenuButton.addActionListener(e -> tetrisView.showMenu());
        add(list);
        add(toMenuButton);
    }

    @Override
    protected void refresh(Model model) {
        list.setListData(model.highScore().toArray(new Integer[0]));
    }
}
