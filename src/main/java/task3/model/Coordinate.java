package task3.model;

import java.util.Objects;

public class Coordinate {
    public final int x;
    public final int y;
    public final static int xStep = 1;
    public final static int yStep = 1;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public Coordinate rotate(Coordinate point) {
        int dx = x - point.x;
        int dy = y - point.y;
        return new Coordinate(point.x - dy, point.y + dx);
    }

    public Coordinate move(int dx,int dy) {
        return new Coordinate(x + dx * xStep, y + dy * yStep);
    } // исправил ошибку

    public Coordinate moveLeft(){ return new Coordinate(x - xStep,y);}

    public Coordinate moveRight(){ return new Coordinate(x + xStep,y);}

    public Coordinate moveDown(){ return new Coordinate (x, y + yStep);}

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
