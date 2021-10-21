package Shapes;
import java.lang.Math;

public class Square implements Shape {
    public static int sides = 4;
    private double[] sideLengths;

    public Square(int length) {
        double[] sideLengths = new double[Square.sides];
        for (int i = 0; i < sideLengths.length; i++) {
            sideLengths[i] = sides;
        }
        
        this.sideLengths = sideLengths;
    }


    @Override
    public double[] getSideLengths() {
        return this.sideLengths;
    }

    @Override
    public double getArea() {
        return Math.pow(this.sideLengths[0], 2);
    }

}
