package Polyhedrons;

import java.util.ArrayList;

import Shapes.Circle;
import Shapes.Rectangle;
import Shapes.Shape;

public class Cylinder extends Polyhedron {
    private int base;
    private int height;

    public Cylinder(int base, int height) {
        super(3);
        this.base = base;
        this.height = height;
        this.baseFace = new Circle(this.base/2);
        this.faceList.add(0, this.baseFace);
        this.faceList.add(1, this.baseFace);
        this.faceList.add(2, new Rectangle(height, (int) this.baseFace.getSideLengths()[0]));
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
