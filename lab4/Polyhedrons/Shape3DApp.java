package Polyhedrons;

import java.util.ArrayList;
import java.util.Scanner;

public class Shape3DApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Total number of polyhedrons: ");
        int hedronTotal = scan.nextInt();

        ArrayList<Polyhedron> hedronList = new ArrayList<Polyhedron>();

        for (int i = 1; i < hedronTotal + 1; i++) {
            System.out.format("Enter Polyhedron %d\n", i);
            String hedronType = scan.next().toLowerCase();
            
            switch(hedronType) {
                case "sphere":
                    System.out.println("Enter radius");
                    int radius = scan.nextInt();
                    hedronList.add(new Sphere(radius));
                    break;
                case "squarepyramid":
                    System.out.println("Enter base and height");
                    int[] pyramidDimensions = new int[2];
                    for (int j = 0; j < pyramidDimensions.length; j++) {
                        pyramidDimensions[j] = scan.nextInt();
                    }
                    hedronList.add(new squarePyramid(pyramidDimensions[0], pyramidDimensions[1]));
                    break;
                case "sp":
                    System.out.println("Enter base and height");
                    int[] spDimensions = new int[2];
                    for (int j = 0; j < spDimensions.length; j++) {
                        spDimensions[j] = scan.nextInt();
                    }
                    hedronList.add(new squarePyramid(spDimensions[0], spDimensions[1]));
                    break;
                case "cuboid":
                    System.out.println("Enter length and width");
                    int[] cuboidDimensions = new int[2];
                    for (int j = 0; j < cuboidDimensions.length; j++) {
                        cuboidDimensions[j] = scan.nextInt();
                    }
                    hedronList.add(new Cuboid(cuboidDimensions[0], cuboidDimensions[1]));
                    break;
                case "cone":
                    System.out.println("Enter base and height");
                    int[] coneDimensions = new int[2];
                    for (int j = 0; j < coneDimensions.length; j++) {
                        coneDimensions[j] = scan.nextInt();
                    }
                    hedronList.add(new Cone(coneDimensions[0], coneDimensions[1]));
                    break;
                case "cylinder":
                    System.out.println("Enter base and height");
                    int[] cylDimensions = new int[2];
                    for (int k = 0; k < cylDimensions.length; k++) {
                        cylDimensions[k] = scan.nextInt();
                    }
                    hedronList.add(new Cylinder(cylDimensions[0], cylDimensions[1]));
                    break;
                default:
                    System.out.println("Enter a valid shape. Choices are squarePyramid, Cuboid, Sphere, Cylinder, and Cone");
                    i--;
                    break;
            }
        }

        double totalArea = 0;

        for (Polyhedron currShape : hedronList) {
            totalArea += currShape.getSurfaceArea();
        }

        System.out.format("Total surface area of polyhedrons: %f\n", totalArea);

        scan.close();
    }
}
