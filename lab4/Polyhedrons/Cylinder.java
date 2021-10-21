package Polyhedrons;

import Shapes.Circle;
import Shapes.Rectangle;

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
}
