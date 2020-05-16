package sample;

import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class MeshViewUtils {

    private MeshViewUtils() {
    }
    public static MeshView createMeshView(TriangleMesh mesh) {
        MeshView meshView = new MeshView(mesh);
        meshView.setDrawMode(DrawMode.FILL);
        meshView.setMaterial(new PhongMaterial());
        meshView.setTranslateX(0);
        meshView.setTranslateY(0);
        meshView.setTranslateZ(0);

        return meshView;
    }

}
