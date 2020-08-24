package task3.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface KeyReleaseListener extends KeyListener {
    @Override
    default void keyTyped(KeyEvent e) {

    }

    @Override
    default void keyPressed(KeyEvent e) {

    }
}
