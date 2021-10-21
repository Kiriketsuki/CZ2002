package Polyhedrons;
import Shapes.Square;
import Shapes.isoscelesTriangle;

public class squarePyramid extends Polyhedron{
    private int base;
    private int height;

    public squarePyramid(int base, int height) {
        super(5);
        this.base = base;
        this.height = height;
        this.baseFace = new isoscelesTriangle(base, height);
        for (int i = 0; i < 4; i++) {
            this.faceList.add(i, this.baseFace);
        }
        Square baseSquare = new Square(base);
        this.faceList.add(4, baseSquare);
    }

    
}
