package sample;

import javafx.geometry.Point3D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;


public class LetterPresenter {

    private LetterView letterView;

    private KeyEventManager keyEventManager;

    public LetterPresenter(LetterView letterView) {
        this.letterView = letterView;
        this.keyEventManager = new KeyEventManager();

        this.setupKeyEventManager();
    }

    private void setupKeyEventManager() {
        this.keyEventManager.addHandler(KeyCode.UP, e -> this.rotateXPositive());
        this.keyEventManager.addHandler(KeyCode.DOWN, e -> this.rotateXNegative());
        this.keyEventManager.addHandler(KeyCode.RIGHT, e -> this.rotateYPositive());
        this.keyEventManager.addHandler(KeyCode.LEFT, e -> this.rotateYNegative());
        this.keyEventManager.addHandler(KeyCode.RIGHT, e -> this.rotateYPositive());
        this.keyEventManager.addHandler(KeyCode.Z, e -> this.increaseScale());
        this.keyEventManager.addHandler(KeyCode.X, e -> this.decreaseScale());
        this.keyEventManager.addHandler(KeyCode.A, e -> this.translateXNegative());
        this.keyEventManager.addHandler(KeyCode.S, e -> this.translateXPositive());
    }

    public void onKeyPressed(KeyEvent e) {
        this.keyEventManager.handleKey(e);
    }

    public void rotateXPositive() {
        this.rotateView(15, Rotate.X_AXIS);
    }

    public void rotateXNegative() {
        this.rotateView(-15, Rotate.X_AXIS);
    }

    public void rotateYNegative() {
        this.rotateView(-15, Rotate.Y_AXIS);
    }

    public void rotateYPositive() {
        this.rotateView(15, Rotate.Y_AXIS);
    }

    private void rotateView(double angle, Point3D axis) {
        this.letterView.rotateLetter(new Rotate(angle, 0, 0, 0, axis));
    }

    public void increaseScale() {
        this.scaleView(1 / 1.1);
    }

    public void decreaseScale() {
        this.scaleView(1.1);
    }

    private void scaleView(double scaleFactor) {
        this.letterView.scaleLetter(new Scale(scaleFactor, scaleFactor, scaleFactor, 0, 0, 0));
    }

    public void translateXNegative() {
        this.translateXView(-10);
    }

    public void translateXPositive() {
        this.translateXView(10);
    }

    public void translateXView(double translateValue) {
        this.letterView.translateXLetter(new Translate(translateValue, 0, 0));
    }

}
