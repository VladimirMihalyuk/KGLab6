package sample;
import javafx.scene.shape.TriangleMesh;

public class LetterMesh {

    // https://stackoverflow.com/questions/19459012/how-to-create-custom-3d-model-in-javafx-8

    private static final int[] FACES = new int[] {
            //face
            1, 0, 0, 0, 3, 0, //2 1 4
            2, 0, 1, 0, 3, 0, //3 2 4
            6, 0, 2, 0, 4, 0, //7 3 4
            6, 0, 4, 0, 5, 0, //7 5 6
            7, 0, 6, 0, 8, 0, //8 7 9
            8, 0, 6, 0, 5, 0, //9 7 6
            9, 0, 7, 0 ,10, 0, //10 8 11
            9, 0, 10, 0, 11, 0, //10 11 12

            //back
            13, 0, 12, 0, 15, 0, //14 13 16
            14, 0, 13, 0, 15, 0, //15 14 16
            18, 0, 14, 0, 16, 0, //19 15 16
            18, 0, 16, 0, 17, 0, //19 17 18
            19, 0, 18, 0, 20, 0, //20 19 21
            20, 0, 18, 0, 17, 0, //21 19 18
            21, 0, 19, 0 ,22, 0, //22 20 23
            21, 0, 22, 0, 23, 0, //22 23 24

            //tacrci
            1, 0, 13, 0, 12, 0, //2 14 13
            1, 0, 12, 0, 0, 0, //2 13 1
            1, 0, 13, 0, 14, 0, //2 14 15
            1, 0, 14, 0, 2, 0, //2 15 3
            2, 0, 14, 0, 18, 0, //3 15 19
            2, 0, 18, 0, 6, 0, //3 19 7
            19, 0, 18, 0, 7, 0, //20 19 8
            7, 0, 18, 0, 6, 0, //8 19 7
            7, 0, 19, 0, 21, 0, //8 20 22
            7, 0, 21, 0, 9, 0, //8 22 10
            21, 0, 23, 0, 9, 0, //22 24 10
            9, 0, 23, 0, 11, 0, //20 24 12
            23, 0, 22, 0, 11, 0, //24 23 12
            11, 0, 22, 0, 10, 0, //12 23 11
            8, 0, 20, 0, 22, 0, //9 21 23
            8, 0, 22, 0, 10, 0, //9 23 11
            20, 0, 17, 0, 8, 0, //21 18 9
            8, 0, 17, 0, 5, 0, //9 18 6
            5, 0, 17, 0, 16, 0, //6 18 17
            5, 0, 16, 0, 4, 0, //6 17 5
            16, 0, 15, 0, 4, 0, //17 16 5
            4, 0, 15, 0, 3, 0, //5 16 4
            15, 0, 12, 0, 3, 0, //16 13 4
            3, 0, 12, 0, 0, 0 //4 13 1

    };

    private TriangleMesh mesh;

    public LetterMesh(float width, float height) {
        this.mesh = new TriangleMesh();

        this.mesh.getPoints().addAll(LetterMesh.calculatePoints(width, height));
        this.mesh.getTexCoords().addAll(0, 0);
        this.mesh.getFaces().addAll(LetterMesh.FACES);
    }

    public TriangleMesh getMesh() {
        return this.mesh;
    }

    private static float[] calculatePoints(float width, float height) {
        return new float[] {
                // x, y, z
                0, 0, 0,  //1
                0, height, 0, //2
                width / 4, height, 0, //3
                width / 4, 0, 0, //4
                width / 4, height * 2 / 3, 0, //5
                width / 2, height / 3, 0, //6
                width / 2, height * 2 / 3, 0, //7
                width * 3 / 4, height, 0, //8
                width * 3 / 4, height * 2 / 3, 0, //9
                width, height, 0, //10
                width * 3 / 4, 0, 0, //11
                width, 0, 0, //12
                0, 0, 50,  //13
                0, height, 50, //14
                width / 4, height, 50, //15
                width / 4, 0, 50, //16
                width / 4, height * 2 / 3, 50, //17
                width / 2, height / 3, 50, //18
                width / 2, height * 2 / 3, 50, //19
                width * 3 / 4, height, 50, //20
                width * 3 / 4, height * 2 / 3, 50, //21
                width, height, 50, //22
                width * 3 / 4, 0, 50, //23
                width, 0, 50, //24

        };
    }

}
