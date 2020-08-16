package task3.model;

import java.awt.*;

public interface ModelState {
    boolean isGameActive();

    int getScore();
    boolean getColor(int x, int y);
}
