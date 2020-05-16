package sample;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Box;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LetterViewController implements LetterView {

    @FXML
    private GridPane gridPane;
    private Group mainGroup;
    private TextArea transformationMatrixTextArea;

    private LetterPresenter presenter;

    private final List<Rotate> initialRotations = new ArrayList<Rotate>() {{
        add(new Rotate(-15, 0, 0, 0, Rotate.Y_AXIS));
        add(new Rotate(-15, 0, 0, 0, Rotate.X_AXIS));
    }};

    public void init() {
        this.presenter = new LetterPresenter(this);

        this.gridPane.setHgap(20);
        this.gridPane.setGridLinesVisible(true);

        this.setupColumns();
        this.setupRows();

        this.mainGroup = new Group();
        this.mainGroup.getTransforms().addAll(this.initialRotations);
        this.gridPane.add(this.mainGroup, 0, 0);

        this.transformationMatrixTextArea = ControlUtils.createReadonlyTextArea(120, 100);
        this.gridPane.add(this.transformationMatrixTextArea, 1, 0);

        this.addLetterMeshViewGroup();
        this.addAxisGroup();

        this.setupKeyEventHandlers();
    }

    private void setupColumns() {
        this.gridPane.getColumnConstraints().clear();

        this.gridPane.getColumnConstraints().add(ControlUtils.createColumn(70, HPos.CENTER));
        this.gridPane.getColumnConstraints().add(ControlUtils.createColumn(25, HPos.RIGHT));
        this.gridPane.getColumnConstraints().add(ControlUtils.createColumn(5, HPos.CENTER));
    }

    private void setupRows() {
        this.gridPane.getRowConstraints().clear();

        this.gridPane.getRowConstraints().add(ControlUtils.createRow(100, VPos.CENTER));
    }

    private void addLetterMeshViewGroup() {
        LetterMesh letterMesh = new LetterMesh(100, 130);
        MeshView letterMeshView = MeshViewUtils.createMeshView(letterMesh.getMesh());

        this.mainGroup.getChildren().add(letterMeshView);
    }

    private void addAxisGroup() {
        Group axis = new Group();

        int width = 300;

        Box xAxis = ControlUtils.createBox(width, 3, 3);
        xAxis.setTranslateY(width / 2);
        xAxis.setTranslateZ(width / 2);

        Box yAxis = ControlUtils.createBox(3, width, 3);
        yAxis.setTranslateX(-width / 2);
        yAxis.setTranslateZ(width / 2);

        Box zAxis = ControlUtils.createBox(3, 3, width);
        zAxis.setTranslateX(-width / 2);
        zAxis.setTranslateY(width / 2);

        axis.getChildren().addAll(xAxis, yAxis, zAxis);
        axis.getTransforms().addAll(this.initialRotations);

        this.gridPane.add(axis, 0, 0);
    }

    private void setupKeyEventHandlers() {
        this.gridPane.requestFocus();
        this.gridPane.addEventHandler(KeyEvent.KEY_PRESSED, this.presenter::onKeyPressed);
    }

    @Override
    public void rotateLetter(Rotate rotate) {
        this.transform(rotate);
    }

    @Override
    public void scaleLetter(Scale scale) {
        this.transform(scale);
    }

    @Override
    public void translateXLetter(Translate translate) {
        this.transform(translate);
    }

    private void transform(Transform transform) {
        this.mainGroup.getTransforms().add(transform);
        this.showTransformationMatrix(transform);
    }

    private void showTransformationMatrix(Transform transform) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        StringBuilder matrix = new StringBuilder();

        matrix
                .append(transform.getClass().getSimpleName())
                .append(": \n");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix
                        .append(decimalFormat.format(transform.getElement(MatrixType.MT_3D_3x4, i, j)))
                        .append(" ");
            }
            matrix.append("\n");
        }

        this.transformationMatrixTextArea.setText(matrix.toString());
    }
}