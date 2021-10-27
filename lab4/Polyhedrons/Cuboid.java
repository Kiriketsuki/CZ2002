package Polyhedrons;

import Shapes.Rectangle;
import Shapes.Square;

public class Cuboid extends Polyhedron {

    public Cuboid(int base, int height) {
        super(4);
        this.baseFace = new Rectangle(height, base);
        Square baseSquare = new Square(base);

        for (int i = 0; i < 6; i++) {
            if (i < 4) {
                this.faceList.add(i, this.baseFace);
            } else {
                this.faceList.add(i, baseSquare);
            }
        }
    }

}
