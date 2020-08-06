package task3.model;

import java.awt.*;
import java.util.Map;
import java.util.Set;

public class ModelStateImpl implements ModelState{
    //TODO: (4) создать тут переменные и конструктор этого класса - суть класса - хранить КОНКРЕТНОЕ состояние модели чтобы его можно было прередать во View
    // все поля нужно сделать final
    // хранить информацию для метода getColor лучше в виде Map<Coordinate, Color>

    boolean gameIsRun;
    final int fieldLenght=100;
    final int fieldWidth =100;
    final Map<Coordinate, Color> coloreSet = null;
    ModelStateImpl( Figure figure){
        Set<Coordinate>iterator = figure.getCoordinates();
       //while(iterator.hasnext()) {//как заполнить map?
        for(Coordinate cor : iterator) {
            Map< iterator(cor), getColor(figure.getx) >?????
        }
       }

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
