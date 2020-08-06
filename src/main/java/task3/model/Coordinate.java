package task3.model;

import java.util.Objects;

public class Coordinate {
    public final int x;
    public final int y;
    public final int xStep = 1;
    public final int yStep = 1;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate rotate(Coordinate point) {
        return null;
    }

    public Coordinate move(Coordinate point) {
        return new Coordinate(x + xStep, y + yStep);
    }

    public Coordinate moveLeft(Coordinate point){ return new Coordinate(x-xStep,y);}

    public Coordinate moveRight(Coordinate point){ return new Coordinate(x+xStep,y);}

    public Coordinate moveDown(Coordinate point){ return new Coordinate (x, y+yStep);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
