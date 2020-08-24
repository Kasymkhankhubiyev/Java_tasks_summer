package task3.view;

import task3.model.Model;
import task3.model.ModelState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FieldScreen extends AbstractScreen {
    private static final Color COLOR_OFF = Color.white;
    private static final Color COLOR_ON = Color.DARK_GRAY;
    private static final Dimension BUTTON_SIZE = new Dimension(30, 30);

    private final JLabel scoreCaption = new JLabel("Score:");
    private final JLabel scoreLabel = new JLabel("0");
    private final JPanel field;
    private final JButton[][] cells;
    private final JButton toMenuButton = new JButton("Main menu");
    private final Model model;
    private final int xSize;
    private final int ySize;
    private boolean isDialogShown = false;

    public FieldScreen(TetrisView tetrisView) {
        super(tetrisView);

        model = tetrisView.getModel();
        xSize = model.xSize();
        ySize = model.ySize();


        field = new JPanel(new GridLayout(ySize, xSize, 1, 1));

        cells = new JButton[xSize][ySize];
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                JButton button = new JButton();
                button.setMinimumSize(BUTTON_SIZE);
                button.setPreferredSize(BUTTON_SIZE);
                button.setMaximumSize(BUTTON_SIZE);
                button.setEnabled(false);
                button.setFocusable(false);
                button.setBackground(COLOR_OFF);
                cells[x][y] = button;
                field.add(button);
            }
        }

        add(scoreCaption);
        add(scoreLabel);
        add(field);
        add(toMenuButton);
        toMenuButton.setFocusable(false);
        toMenuButton.addActionListener(e -> tetrisView.showMenu());

        tetrisView.frame.setFocusable(true);
        tetrisView.frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN)
                    model.moveDown();
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                    model.moveRight();
                else if (e.getKeyCode() == KeyEvent.VK_LEFT)
                    model.moveLeft();
                else if (e.getKeyCode() == KeyEvent.VK_CONTROL)
                    model.rotate();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


    }

    @Override
    protected void refresh(Model model) {

    }

    protected void refreshModelState(ModelState modelState) {
        scoreLabel.setText("" + modelState.getScore());
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                if (modelState.getColor(x, y))
                    cells[x][y].setBackground(COLOR_ON);
                else
                    cells[x][y].setBackground(COLOR_OFF);
            }
        }
        if (!modelState.isGameActive() && !isDialogShown) {
            isDialogShown = true;
            JOptionPane.showConfirmDialog(tetrisView.frame,"GAME OVER. SCORE:" + modelState.getScore(), "Game over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            tetrisView.showMenu();
            isDialogShown = false;
        }
    }
}
