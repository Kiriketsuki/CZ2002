package Polyhedrons;

import Shapes.Circle;

public class Cone extends Polyhedron {
    private double radius;
    private int height;

    public Cone(int height, double radius) {
        super(2);
        this.baseFace = new Circle(radius);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getSurfaceArea() {
        return Math.PI * this.radius * (this.radius + Math.pow((Math.pow(this.height, 2)) + Math.pow(this.radius, 2), 0.5));
    }
    
}
