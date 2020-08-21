package task3.model;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Figure {
    final int x;
    final int y;
    final Set<Coordinate> elements;
    final FigureType type;

    public Figure(int x, int y, Set<Coordinate> elements, FigureType type) {
        this.x = x;
        this.y = y;
        this.elements = elements;
        this.type=type;
    }

    public Figure moveDown(){
        return new Figure(x, y + 1, elements,type);
    }

    public Figure moveUp(){
        return new Figure(x, y - 1, elements, type);
    }

    public Figure moveHorizontal(int dx){
        return new Figure(x + dx, y, elements, type);
    }

    public Figure rotate(){
        //TODO rotate figure
        //основная точка (0.0)
        switch (type){
            case Z:
            case S:
            case T:
            case O:
            case J:
            case I:
            case L:
        }

        return this;
    }

    public Set<Coordinate> getAbsoluteCoordinates() {
        Set<Coordinate> ans = new HashSet<>();
        elements.forEach(
                coordinate -> {
                    ans.add(coordinate.move(x, y));
                }
        );
        return ans;
    }

    public Set<Coordinate> getCoordinates(){
        return elements;
    }
}
