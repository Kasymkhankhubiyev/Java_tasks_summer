package task3.model;

import java.awt.*;
import java.util.Map;
import java.util.Set;

public class ModelStateImpl implements ModelState{
    final boolean gameIsRun;
    final int score;
    final Set<Coordinate> colorSet;

    public ModelStateImpl(boolean gameIsRun, int score, Set<Coordinate> colorSet) {
        this.gameIsRun = gameIsRun;
        this.score = score;
        this.colorSet = colorSet;
    }

    @Override
    public boolean isGameActive() {
        return gameIsRun;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public boolean getColor(int x, int y) {
        return colorSet.contains(new Coordinate(x, y));
    }
}
