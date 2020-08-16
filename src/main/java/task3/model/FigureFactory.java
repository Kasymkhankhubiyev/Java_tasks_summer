package task3.model;

import java.util.HashSet;
import java.util.Set;

public class FigureFactory {
    public static Figure createFigure(FigureType figureType) {//здесь достаточно передавать только тип, сдвинуть фигуру на нужную координату мы сегда можем и так
        //фигуры друг от друга отличаются только набором элементов
        Set<Coordinate> elements = new HashSet<>();
        switch (figureType) {
            case I:
                for (int i = 0; i < 4; i++) elements.add(new Coordinate(i, 0));
                break;
            case L:
                for (int i = 0; i < 3; i++) elements.add(new Coordinate(i, 1));
                elements.add(new Coordinate(0, 0));
                break;
            case J:
                for (int i = 0; i < 3; i++) elements.add(new Coordinate(i, 1));
                elements.add(new Coordinate(3, 0));
                break;
            case O:
                for (int i = 0; i <= 1; i++)
                    for (int j = 0; j <= 1; j++) elements.add(new Coordinate(i, j));
                break;
            case T:
                for (int i = 0; i < 3; i++) elements.add(new Coordinate(i, 0));
                elements.add(new Coordinate(1, 1));
                break;
            case S:
                elements.add(new Coordinate(2, 0));
                for (int i = 0; i <= 2; i++) elements.add(new Coordinate(1, i));
                elements.add(new Coordinate(0, 2));
                break;
            case Z:
                elements.add(new Coordinate(0, 0));
                for (int i = 0; i <= 1; i++) elements.add(new Coordinate(1, i));
                elements.add(new Coordinate(2, 2));
                break;

            default:
                throw new RuntimeException("Figure type not supported");
        }
        return new Figure(0, 0, elements);
    }
}

