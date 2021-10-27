package Polyhedrons;

import Shapes.Circle;
import Shapes.Shape;
import java.lang.Math;
import java.util.ArrayList;

public class Sphere extends Polyhedron {

    private double radius;
    // private ArrayList<Shape> faceList = new ArrayList<Shape>();

    public Sphere(double radius) {
        super(1);
        Circle baseFace = new Circle(radius);
        this.radius = radius;
        this.baseFace = baseFace;
        // volume 4*circle area
        ArrayList<Shape> faceList = new ArrayList<Shape>();
        for (int i = 0; i < 4; i++) {
            faceList.add(i, this.baseFace);
        }
        this.faceList = faceList;
    }

    @Override
    public double getVolume() {
        return (4/3) * Math.PI * Math.pow(this.radius, 3);
    }

    // @Override
    // public double getSurfaceArea() {
    //     double to_return = 0.0;
    //     for (Shape shape : this.faceList) {
    //         to_return += shape.getArea();
    //     }
    //     return to_return;
    // }

    
}
