package task3.view;

import task3.model.Model;

import javax.swing.*;

public class MenuScreen extends AbstractScreen {
    private final JButton newGameButton = new JButton("New game");
    private final JButton highScoresButton = new JButton("High Scores");
    private final JButton aboutButton = new JButton("About");
    private final JButton exitButton = new JButton("Exit");


    public MenuScreen(TetrisView tetrisView) {
        super(tetrisView);
        newGameButton.addActionListener(e -> tetrisView.showField());
        highScoresButton.addActionListener(e -> tetrisView.showHighScores());
        aboutButton.addActionListener(e -> tetrisView.showAbout());
        exitButton.addActionListener(e -> tetrisView.exit());

        add(newGameButton);
        add(highScoresButton);
        add(aboutButton);
        add(exitButton);
    }

    @Override
    protected void refresh(Model model) {}


}
