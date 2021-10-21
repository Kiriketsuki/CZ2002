package Shapes;
public class Rectangle implements Shape {
    public static int sides = 4;
    private double[] sideLengths;

    public Rectangle(int length, int width) {
        double[] sideLengths = new double[Rectangle.sides];
        for (int i = 0; i < sideLengths.length; i++) {
            if (i % 2 == 0) {
                sideLengths[i] = length;
            } else {
                sideLengths[i] = width;
            }
        }

        this.sideLengths = sideLengths;
    }

    @Override
    public double[] getSideLengths() {
        return this.sideLengths;
    }

    @Override
    public double getArea() {
        return (double) (this.sideLengths[0] * this.sideLengths[1]); 
    }
    
}
