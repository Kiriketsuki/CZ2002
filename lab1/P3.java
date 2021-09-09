package lab1;
import java.util.*;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int starting = sc.nextInt();
        int ending = sc.nextInt();
        int increment = sc.nextInt();

        // error
        if (starting + increment > ending) {
            System.out.println("Error");
            sc.close();
            return;
        }

        // for loop

        System.out.println("US$          S$");
        System.out.println("---------------");
        for (int i = starting; i <= ending; i += increment) {
            System.out.print(i);
            System.out.print("          ");
            System.out.println(i*1.82);
        }

        // while loop
        System.out.println("US$          S$");
        System.out.println("---------------");
        int i = starting;
        while (i <= ending) {
            System.out.print(i);
            System.out.print("          ");
            System.out.println(i*1.82);
            i += increment;
        }

        // do while loop
        System.out.println("US$          S$");
        System.out.println("---------------");
        int j = starting;
        do {
            System.out.print(j);
            System.out.print("          ");
            System.out.println(j*1.82);
            j += increment;
        } while (j <= ending);

        sc.close();
        return;
    }
}
