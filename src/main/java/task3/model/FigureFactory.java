package task3.model;

import task3.model.figureTypes.Hero;

public class FigureFactory {
    public Figure createFigure(FigureType figureType, int x, int y) //будем передавать тип и координату прорисовки
    {
       Figure figure;
       switch (figureType){
           case I:
               figure = new Hero(new Coordinate(x,y));
       }
    }
}
