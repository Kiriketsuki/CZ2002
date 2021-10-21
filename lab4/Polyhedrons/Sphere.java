package Polyhedrons;

import Shapes.Circle;
import Shapes.Shape;
import java.lang.Math;
import java.util.ArrayList;

public class Sphere extends Polyhedron {

    private double radius;


    public Sphere(double radius) {
        super(1);
        Circle baseFace = new Circle(radius);
        this.baseFace = baseFace;
        // volume 4*circle area
        ArrayList<Shape> faceList = new ArrayList<Shape>(4);
        for (int i = 0; i < faceList.size(); i++) {
            faceList.add(i, this.baseFace);
        }
        this.faceList = faceList;
    }

    @Override
    public double getVolume() {
        return (4/3) * Math.PI * Math.pow(this.radius, 3);
    }

    
}
