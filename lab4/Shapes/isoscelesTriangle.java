package Shapes;
public class isoscelesTriangle implements Shape{

    public static int sides = 3;
    private double[] sideLengths;

    public isoscelesTriangle(int base, int height) {
        double[] sideLengths = new double[isoscelesTriangle.sides];
        sideLengths[0] = base;
        sideLengths[1] = height;
        sideLengths[2] = 0;

        this.sideLengths = sideLengths;
    }


    @Override
    public double[] getSideLengths() {
        return this.sideLengths;
    }

    @Override
    public double getArea() {
        return (0.5) * this.sideLengths[0] * this.sideLengths[1];
    }
    
}
