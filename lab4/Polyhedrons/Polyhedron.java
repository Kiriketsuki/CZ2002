package Polyhedrons;
import java.util.ArrayList;
import Shapes.Shape;

public class Polyhedron {
    int numberOfFaces;
    ArrayList<Shape> faceList = new ArrayList<Shape>();
    Shape baseFace;

    public Polyhedron(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
        ArrayList<Shape> faceList = new ArrayList<Shape>(numberOfFaces);
        this.faceList = faceList;
    }

    public double getVolume() {
        return 0.0;
    }

    public double getSurfaceArea() {
        double surfaceArea = 0.0;
        for (Shape shape : this.faceList) {
            surfaceArea += shape.getArea();
        }

        return surfaceArea;
    }
}
