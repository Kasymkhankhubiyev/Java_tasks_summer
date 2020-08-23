package task3.model;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Figure {
    final int x;
    final int y;
    final Coordinate rotationPoint;
    final Set<Coordinate> elements;
    final FigureType type;

    public Figure(int x, int y, Set<Coordinate> elements, FigureType type, Coordinate rotationPoint) {
        this.x = x;
        this.y = y;
        this.elements = elements;
        this.type=type;
        this.rotationPoint = rotationPoint;
    }

    public Figure moveDown(){
        return new Figure(x, y + 1, elements,type, rotationPoint);
    }

    public Figure moveUp(){
        return new Figure(x, y - 1, elements, type, rotationPoint);
    }

    public Figure moveHorizontal(int dx){
        return new Figure(x + dx, y, elements, type, rotationPoint);
    }

    public Figure rotate(){
        Set<Coordinate> newElements = new HashSet<>();
        for (Coordinate element: elements){
            newElements.add(element.rotate(rotationPoint));
        }
        return new Figure(x, y, newElements, type, rotationPoint);
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
