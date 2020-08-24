package task3.view;

import task3.model.Model;
import task3.model.ModelState;
import task3.model.View;

import javax.swing.*;
import java.awt.*;

public class TetrisView implements View {
    private final Model model;
    final JFrame frame = new JFrame("Tetris");
    private final JPanel root = new JPanel();

    private final AboutScreen aboutScreen = new AboutScreen(this);
    private final FieldScreen fieldScreen;
    private final HighScoresScreen highScoresScreen = new HighScoresScreen(this);
    private final MenuScreen menuScreen = new MenuScreen(this);

    public TetrisView(Model model) {
        this.model = model;
        fieldScreen = new FieldScreen(this);
        frame.setPreferredSize(new Dimension(400, 750));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.setResizable(false);
        model.setView(this);
        root.add(menuScreen);
    }

    @Override
    public void updateView(ModelState modelState) {
        SwingUtilities.invokeLater(() -> {
            fieldScreen.refreshModelState(modelState);
            root.revalidate();
            root.repaint();
        });
    }

    public void start(){
        frame.pack();
        frame.setVisible(true);
    }

    protected void showMenu(){
        model.endGame();
        changeScreen(menuScreen);
    }

    protected void showField(){
        changeScreen(fieldScreen);
        model.restart();
    }

    protected void showHighScores(){
        changeScreen(highScoresScreen);
    }

    protected void showAbout(){
        changeScreen(aboutScreen);
    }

    protected void exit(){
        model.endGame();
        frame.dispose();
    }

    private void changeScreen(AbstractScreen screen) {
        root.removeAll();
        root.add(screen);
        screen.refresh(model);
        root.revalidate();
        root.repaint();
    }

    protected Model getModel(){
        return model;
    }
}
