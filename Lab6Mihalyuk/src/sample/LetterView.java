package sample;

import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public interface LetterView {
    void rotateLetter(Rotate rotate);
    void scaleLetter(Scale scale);
    void translateXLetter(Translate translate);
}

