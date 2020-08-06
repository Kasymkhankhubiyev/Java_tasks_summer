package task3.model;

import task2.Command;

public class FigureFactory {
    public Figure createFigure(FigureType figureType)
    {
       Figure figure = new Class.forName(figureType);
    }
}
