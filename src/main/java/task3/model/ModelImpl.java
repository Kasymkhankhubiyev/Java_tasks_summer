package task3.model;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ModelImpl implements Model{
    public static final int xSize = 10;
    public static final int ySize = 20;

    private boolean gameIsRun = false; //если true - игра активна
    private int score = 0;
    private Figure figure = null;
    private Set<Coordinate> fallenElements = new HashSet<>();
    private View view = null;
    private List<Integer> highScore = new ArrayList<>();
    private Timer timer = new Timer(true);

    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {moveDownOnTimer();}
    };

    public void updateView() {
        Set<Coordinate> elementSet = new HashSet<>();
        elementSet.addAll(fallenElements);
        elementSet.addAll(figure.getAbsoluteCoordinates());
        ModelStateImpl modelStateImpl = new ModelStateImpl(gameIsRun, score, elementSet);
        view.updateView(modelStateImpl);
    }

    private void checkCompleteRow() {
        for (int y = 0; y < ySize; y++){ //проверка строки.
            int k=0;
            for(int x = 0; x < xSize; x++){
                Coordinate coordinate = new Coordinate(x, y);
                if(fallenElements.contains(coordinate)) k = k + 1;
            }
            if (k == xSize){
                rowClear(y);
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
        if (gameIsRun) {
            Figure newFigure = figure.moveDown();
            if (checkFigurePlace(newFigure)) {
                figure = newFigure;
            } else {
                fallenElements.addAll(figure.getAbsoluteCoordinates());
                checkCompleteRow();
                spawnNewFigure();
            }
            updateView();
        }
    }

    private void spawnNewFigure() {
        int randomNumber = new Random().nextInt(7);
        FigureType randomFigureType;
        switch (randomNumber) {
            case 0: randomFigureType = FigureType.I;
            break;
            case 1: randomFigureType = FigureType.J;
                break;
            case 2: randomFigureType = FigureType.L;
                break;
            case 3: randomFigureType = FigureType.O;
                break;
            case 4: randomFigureType = FigureType.S;
                break;
            case 5: randomFigureType = FigureType.T;
                break;
            case 6: randomFigureType = FigureType.Z;
                break;
            default:
                throw new RuntimeException("Unknown figure number");
        }
        Figure newFigure = FigureFactory.createFigure(randomFigureType);

        if (checkFigurePlace(newFigure)) {
            figure = newFigure;
        } else {
            looseGame();
        }
    }

    private void looseGame() {
        timer.cancel();
        gameIsRun = false;
        highScore.add(score);
        highScore.sort(Comparator.comparingInt(value -> value));
        updateView();
    }


    @Override
    public int xSize() {
        return xSize;
    }

    @Override
    public int ySize() {
        return ySize;
    }

    @Override
    public void moveLeft() {
        if (gameIsRun) {
            Figure newFigure = figure.moveHorizontal(-1);
            if (checkFigurePlace(newFigure)) {
                figure = newFigure;
                updateView();
            }
        }
    }

    @Override
    public void moveRight() {
        if (gameIsRun) {
            Figure newFigure = figure.moveHorizontal(1);
            if (checkFigurePlace(newFigure)) {
                figure = newFigure;
                updateView();
            }
        }
    }

    @Override
    public void moveDown() {
        if (gameIsRun) {
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
    }

    @Override
    public void rotate() {
        if (gameIsRun) {
            Figure newFigure = figure.rotate();
            if (checkFigurePlace(newFigure)) {
                figure = newFigure;
                updateView();
            }
        }
    }

    @Override
    public void endGame() {
        timer.cancel();
        gameIsRun = false;
    }

    @Override
    public void restart() {
        score = 0;
        gameIsRun = true;
        fallenElements.clear();
        spawnNewFigure();
        updateView();
        if (timer != null) timer.cancel();
        timer = new Timer(true);
        timerTask = new TimerTask() {
            @Override
            public void run() {moveDownOnTimer();}
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
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
