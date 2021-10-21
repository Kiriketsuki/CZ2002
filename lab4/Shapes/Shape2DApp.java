package Shapes;
import java.util.*;

public class Shape2DApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Total number of shapes: ");
        int shapesTotal = scan.nextInt();

        ArrayList<Shape> shapeList = new ArrayList<Shape>();

        for (int i = 1; i < shapesTotal + 1; i++) {
            System.out.format("Enter Shape %d\n", i);
            String shapeType = scan.next().toLowerCase();
            
            switch(shapeType) {
                case "circle":
                    System.out.println("Enter radius");
                    int radius = scan.nextInt();
                    shapeList.add(new Circle(radius));
                    break;
                case "square":
                    System.out.println("Enter length");
                    int length = scan.nextInt();
                    shapeList.add(new Square(length));
                    break;
                case "triangle":
                    System.out.println("Enter base and height");
                    int[] triangleDimensions = new int[isoscelesTriangle.sides-1];
                    for (int j = 0; j < triangleDimensions.length; j++) {
                        triangleDimensions[j] = scan.nextInt();
                    }
                    shapeList.add(new isoscelesTriangle(triangleDimensions[0], triangleDimensions[1]));
                    break;
                case "rectangle":
                    System.out.println("Enter length and width");
                    int[] rectangleDimensions = new int[2];
                    for (int j = 0; j < rectangleDimensions.length; j++) {
                        rectangleDimensions[j] = scan.nextInt();
                    }
                    shapeList.add(new Rectangle(rectangleDimensions[0], rectangleDimensions[1]));
                    break;
                default:
                    System.out.println("Enter a valid shape. Choices are Square, Rectangle, Triangle, and Circle");
                    i--;
                    break;
            }
        }

        double totalArea = 0;

        for (Shape currShape : shapeList) {
            totalArea += currShape.getArea();
        }

        System.out.format("Total area of shapes: %f\n", totalArea);

        scan.close();
    }
}
