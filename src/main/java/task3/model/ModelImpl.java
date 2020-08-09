package task3.model;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModelImpl implements Model{
    //TODO: (3) создать здесь все переменные которые определяют состояние модели:
    //  активна ли игра, текущая "падающая" фигура, координаты упавших ячеек, очки, список рекордов, экземпляр View, мб еще что-то
    boolean gameIsRun; //если true - игра активна
    int score;
    Figure Figure;
    Map<Coordinate, Color> colorSet;

    ModelImpl() {
        for(int i =0; i< 10; i++) {
            for (int j; j < 10; j++) {
                Coordinate cor = new Coordinate(i,j);
                Color color = "White";

            }
        }
        score = 0;
    }


    public void updateView() {
        //TODO: (9) создать здесь класс ModelStateImpl а затем вызвать у экземпляра View медод updateView передав в него созданый ModelStateImpl
        // самое сложное для создания ModelStateImpl - понять какие ячейки в какие цвета красить - нужно учесть как падующую фигуру так и лежащие на полу
        // далее мы должны дергать этот метод каждый раз после того как меняем состояние модели, чтобы оно отрисовалось
        ModelStateImpl modelStateImpl = new ModelStateImpl(gameIsRun,score,colorSet);
    }

    private void checkCompleteRow() {
        //TODO: (15) этот метод мы будем вызывать каждый раз когда нужно проверить заполненные полностью линии и удалить + начислить очки
    }

    private void moveDownOnTimer() {
        //TODO: (16) этот метод мы будем вызывать каждый раз когда фигура должна сместиться вниз по таймеру (раз в секунду например)
        // соответсвенно если мы не можем этого сделать, значит фигура упала до конца и нужно создать новую фигуру методом spawnNewFigure
    }

    private void spawnNewFigure() {
        //TODO: (17) здесь мы создаем новую рандомную фигуру, и если мы не можем это сделать, то игра закончена (выйти в меню, обновить рекорды)
    }

    @Override
    public void moveLeft() {
        //TODO: (13) реализовать метод - нужно сдвинуть фигуру текущую влево в случае если мы можем это сделать (игра должна быть активна, нужные ячейки свободны)
    }

    @Override
    public void moveRight() {
        //TODO: (14) реализовать метод аналогично moveLeft (стараться не дублировать код, вынести общее в какой-то дополнительный метод)
    }

    @Override
    public void moveDown() {
        //TODO: (18) эта команда "роняет" фигурку вниз до конца
    }

    @Override
    public void rotate() {
        //TODO: (19) поворот фигуры если возможно
    }

    @Override
    public void endGame() {
        //TODO: (12) реализовать метод - сделать игру сейчас неактивной (выйти в меню)
    }

    @Override
    public void restart() {
        //TODO: (11) реализовать метод - нужно привести модель в состояние начала игры
    }

    @Override
    public List<Integer> highScore() {
        //TODO: (10) реализовать метод
        return null;
    }

    @Override
    public void setView(View view) {
        //TODO: (8) реализовать метод - нужно "запомнить" переданный вью

    }
}
