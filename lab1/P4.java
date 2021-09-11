import java.util.*;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();

        if (height <= 0) {
            sc.close();
            System.out.println("Error");
            return;
        }
        
        char [] chars = {'B', 'A'};

        for (int i = 1; i < height + 1; i++) {
            int curr = i % 2; // if odd, will start with A, if even, will start with B
            for (int j = 0; j < i; j++) {
                System.out.print(chars[curr]);
                System.out.print(chars[curr]);
                curr = 1 - curr; // toggle between A and B
            }

            System.out.println();
        }

        sc.close();
    }
}
