package task3.model;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ModelImpl implements Model{
    public static final int xSize = 20;
    public static final int ySize = 20;

    private boolean gameIsRun = false; //если true - игра активна
    private int score = 0;
    private Figure figure = null;
    private Set<Coordinate> fallenElements = new HashSet<>();
    private View view = null;
    private List<Integer> highScore = new ArrayList<>();
    private Timer timer;

    //TODO: add timer with calls of .moveDownOnTimer()
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() { //что делать с run()?
            Figure newFigure = figure;
            figure = newFigure.moveDown();
            if (checkFigurePlace(newFigure)) {
                figure = newFigure;
            } else {
                fallenElements.addAll(figure.getAbsoluteCoordinates());
                checkCompleteRow();
                spawnNewFigure();
            }
        }
    };

    public void updateView() {
        Set<Coordinate> elementSet = new HashSet<>();
        elementSet.addAll(fallenElements);
        elementSet.addAll(figure.getAbsoluteCoordinates());
        ModelStateImpl modelStateImpl = new ModelStateImpl(gameIsRun, score, elementSet);
        view.updateView(modelStateImpl);
    }

    private void checkCompleteRow() {
        for (int i = 0; i < ySize; i++){ //проверка строки.
            int k=0;
            for(int j = 0; j < xSize; j++){
                Coordinate coordinate = new Coordinate(i,j);
                if(fallenElements.contains(coordinate)) k = k + 1;
            }
            if (k == xSize){
                rowClear(i);
                scoreGrowth();
            }
        }
    }

    private void rowClear(int j){
//        for(int k = 0; k < xSize; k++){
//            Coordinate coordinate = new Coordinate(k, j);
//            fallenElements.remove(coordinate);
//        }
        fallenElements.removeIf(coordinate -> coordinate.y == j);
        Set<Coordinate> coords = new HashSet<>();
        fallenElements.forEach(coordinate -> {if (coordinate.y < j) coords.add(coordinate);});
        fallenElements.removeAll(coords);
        coords.forEach(coordinate -> fallenElements.add(coordinate.moveDown()));
    }

    private void scoreGrowth(){
        score = score + 10;
    }

    private boolean checkFigurePlace(Figure figureToCheck) {
        for(Coordinate coordinate : figureToCheck.getAbsoluteCoordinates()) {
            if (coordinate.y < 0) return false;
            if (coordinate.x < 0) return false;
            if (coordinate.y >= ySize) return false;
            if (coordinate.x >= xSize) return false;
            if (fallenElements.contains(coordinate)) return false;
        }
        return true;
    }

    private void moveDownOnTimer() {
        timer.scheduleAtFixedRate(timerTask,0,1000);
//        if (checkFigurePlace(newFigure)) {
//            figure = newFigure;
//        } else {
//            fallenElements.addAll(figure.getAbsoluteCoordinates());
//            checkCompleteRow();
//            spawnNewFigure();
//        }
        updateView();
    }

    private void spawnNewFigure() {
        Figure newFigure = FigureFactory.createFigure(FigureType.I);

        if (checkFigurePlace(newFigure)) {
            figure = newFigure;
        } else {
            looseGame();
        }
    }

    private void looseGame() {
        gameIsRun = false;
        highScore.add(score);
        highScore.sort(Comparator.comparingInt(value -> value));
    }


    @Override
    public void moveLeft() {
        Figure newFigure = figure.moveHorizontal(-1);
        if (checkFigurePlace(newFigure)) {
            figure = newFigure;
            updateView();
        }
    }

    @Override
    public void moveRight() {
        Figure newFigure = figure.moveHorizontal(1);
        if (checkFigurePlace(newFigure)) {
            figure = newFigure;
            updateView();
        }
    }

    @Override
    public void moveDown() {
        Figure newFigure = figure;
        while (checkFigurePlace(newFigure)) {
            newFigure = newFigure.moveDown();
        }
        newFigure = newFigure.moveUp();
        fallenElements.addAll(newFigure.getAbsoluteCoordinates());
        checkCompleteRow();
        spawnNewFigure();
        updateView();
    }

    @Override
    public void rotate() {
        Figure newFigure = figure.rotate();
        if (checkFigurePlace(newFigure)) {
            figure = newFigure;
            updateView();
        }
    }

    @Override
    public void endGame() {
        gameIsRun = false;
    }

    @Override
    public void restart() {
        score = 0;
        gameIsRun = true;
        fallenElements.clear();
        spawnNewFigure();
        timer = new Timer();
        updateView();
    }

    @Override
    public List<Integer> highScore() {
        return highScore;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }
}
