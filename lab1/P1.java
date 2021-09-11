import java.util.*;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice = sc.next().toLowerCase().charAt(0);
        
        switch(choice) {
            case 'a':
                System.out.println("Action movie fan");
                break;
            case 'c':
                System.out.println("Comedy movie fan");
                break;
            case 'd':
                System.out.println("Drama movie fan");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        sc.close();
    }
    
}
