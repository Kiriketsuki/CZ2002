package Shapes;
import java.lang.Math;

public class Circle implements Shape {
    public static int sides = 1;
    private double[] sideLengths;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        double[] sideLengths = new double[Circle.sides];
        sideLengths[0] = 2 * radius * Math.PI;

        this.sideLengths = sideLengths;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public double[] getSideLengths() {
        return this.sideLengths;
    }

    @Override
    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }
    
}
