package task3.model;

import java.awt.*;

public class ModelStateImpl implements ModelState{
    //TODO: (4) создать тут переменные и конструкто этого класса - суть класса - хранить КОНКРЕТНОЕ состояние модели чтобы его можно было прередать во View
    // все поля нужно сделать final
    // хранить информацию для метода getColor лучше в виде Map<Coordinate, Color>

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
