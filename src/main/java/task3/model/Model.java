package task3.model;

import java.util.List;

public interface Model {
    int xSize();
    int ySize();
    void moveLeft();
    void moveRight();
    void moveDown();
    void rotate();

    void endGame();
    void restart();
    List<Integer> highScore();

    void setView(View view);
}
