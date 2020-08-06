package task3.model;

import java.awt.*;
import java.util.Map;
import java.util.Set;

public class ModelStateImpl implements ModelState{
    //TODO: (4) создать тут переменные и конструктор этого класса - суть класса - хранить КОНКРЕТНОЕ состояние модели чтобы его можно было прередать во View
    // все поля нужно сделать final
    // хранить информацию для метода getColor лучше в виде Map<Coordinate, Color>
    // здесь нужны только те данные которые мы отдаем через интерфейс ModelState , поэтому fieldLenght/Width не нужны

    final boolean gameIsRun;
    final int score;
    final Map<Coordinate, Color> colorSet;

    public ModelStateImpl(boolean gameIsRun, int score, Map<Coordinate, Color> colorSet) {
        this.gameIsRun = gameIsRun;
        this.score = score;
        this.colorSet = colorSet;
    }

    @Override
    public boolean isGameActive() {
        //TODO: (5) реализовать метод
        return false;
    }

    @Override
    public int getScore() {
        //TODO: (6) реализовать метод
        return 0;
    }

    @Override
    public Color getColor(int x, int y) {
        //TODO: (7) реализовать метод
        return null;
    }
}
