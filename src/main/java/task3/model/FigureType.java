package task3.model;

import java.util.Set;

public enum FigureType {
    L, J, I, Z, S, T, O
}

class Hero(){
    final int x;
    final int y;
    final Set<Coordinate> elements = null;

    Hero (int x, int y) { //Соответствует I
        this.x = x;
        this.y = y;
        int i = 1;
        while (i < 5) {
            this.elements.add(new Coordinate(x + i, y + i));
            i++;
        }
    }

    class Ricky () { //соответствует L
        final int x;
        final int y;
        final Set<Coordinate> elements = null;

        Ricky(int x, int y) { //Соответствует I
            this.x = x;
            this.y = y;
            int i = 1;
            while (i < 4) {
                this.elements.add(new Coordinate(x + i, y + i));
                i++;
            }
            this.elements.add(new Coordinate(x + i, y + i + 1));
        }
    }
}
