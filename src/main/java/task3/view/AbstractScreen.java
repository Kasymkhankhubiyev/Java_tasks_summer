package task3.view;

import task3.model.Model;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractScreen extends JPanel {
    protected final TetrisView tetrisView;

    public AbstractScreen(TetrisView tetrisView) {
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        this.tetrisView = tetrisView;
    }

    protected abstract void refresh(Model model);
}
