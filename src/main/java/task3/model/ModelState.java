package task3.model;

import java.awt.*;

public interface ModelState {
    boolean isGameActive();

    int getScore();
    Color getColor(int x, int y);
}
