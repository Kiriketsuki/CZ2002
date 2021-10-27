package Polyhedrons;
import java.util.ArrayList;

import Shapes.Shape;
import Shapes.Square;
import Shapes.isoscelesTriangle;

public class squarePyramid extends Polyhedron{
    private int base;
    private int height;
    private ArrayList<Shape> faceList = new ArrayList<Shape>();

    public squarePyramid(int base, int height) {
        super(5);
        this.base = base;
        this.height = height;
        this.baseFace = new isoscelesTriangle(base, height);
        for (int i = 0; i < 4; i++) {
            this.faceList.add(i, this.baseFace);
        }
        Square baseSquare = new Square(base);
        this.faceList.add(4, baseSquare);
    }

    @Override
    public double getSurfaceArea() {
        double to_return = 0;
        for (Shape shape : this.faceList) {
            to_return += shape.getArea();
        }
        return to_return;
    }
}
