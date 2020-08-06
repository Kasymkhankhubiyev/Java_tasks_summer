package task3.model;

import java.util.HashSet;
import java.util.Set;

public class FigureFactory {
    public Figure createFigure(FigureType figureType) {//здесь достаточно передавать только тип, сдвинуть фигуру на нужную координату мы сегда можем и так
        //фигуры друг от друга отличаются только набором элементов
        Set<Coordinate> elements = new HashSet<>();
        switch (figureType){
            case I:
                for (int i = 0; i < 4; i++) elements.add(new Coordinate(i, 0));
                break;
            case L:
                for (int i = 0; i <= 3; i++) elements.add(new Coordinate(i, 1));
                elements.add(new Coordinate(0, 0));
                break;

            //TODO: (2) добавить все оставшиеся типы фигур
            default:
                throw new RuntimeException("Figure type not supported");
        }
        return new Figure(0, 0, elements);
    }
}
