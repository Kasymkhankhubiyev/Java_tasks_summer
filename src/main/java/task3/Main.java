package task3;

import task3.model.Model;
import task3.model.ModelState;
import task3.model.View;
import task3.view.TetrisView;

import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Model model = new Model() {
            @Override
            public void moveLeft() {

            }

            @Override
            public void moveRight() {

            }

            @Override
            public void moveDown() {

            }

            @Override
            public void rotate() {

            }

            @Override
            public void endGame() {

            }

            @Override
            public void restart() {

            }

            @Override
            public List<Integer> highScore() {
                return null;
            }

            @Override
            public void setView(View view) {
                view.updateView(new ModelState() {
                    @Override
                    public boolean isGameActive() {
                        return true;
                    }

                    @Override
                    public int getScore() {
                        return 1337;
                    }

                    @Override
                    public Color getColor(int x, int y) {
                        if (x == 1 && y == 1)
                            return Color.RED;
                        return Color.WHITE;
                    }
                });
            }
        };


        TetrisView tetrisView = new TetrisView(model);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                tetrisView.start();
            }
        });
    }


}
