package Shapes;
import java.lang.Math;

public class Circle implements Shape {
    public static int sides = 1;
    private double[] sideLengths;

    public Circle(double radius) {
        double[] sideLengths = new double[Circle.sides];
        sideLengths[0] = 2 * radius * Math.PI;

        this.sideLengths = sideLengths;
    }

    @Override
    public double[] getSideLengths() {
        return this.sideLengths;
    }

    @Override
    public double getArea() {
        double radius = (this.sideLengths[0]/Math.PI)/2;
        return Math.pow(radius, 2) * Math.PI;
    }
    
}
