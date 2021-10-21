package Polyhedrons;

import Shapes.Rectangle;
import Shapes.Square;

public class Cuboid extends Polyhedron {

    public Cuboid(int base, int height) {
        super(4);
        this.baseFace = new Rectangle(height, base);
        Square baseSquare = new Square(base);

        for (int i = 0; i < this.faceList.size(); i++) {
            if (i % 2 == 0) {
                this.faceList.add(i, this.baseFace);
            } else {
                this.faceList.add(i, baseSquare);
            }
        }
    }
    
}
