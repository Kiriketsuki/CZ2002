package lab1;
import java.util.*;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char to_return = 'A';
        int user_salary = sc.nextInt();
        int user_merit = sc.nextInt();

        if (user_salary < 600) {
            to_return = 'C';
        } else if (user_salary >= 600 && user_salary < 650) {
            if (user_merit < 10) {
                to_return = 'C';
            } else {
                to_return = 'B';
            }
        } else if (user_salary <  700) {
            to_return = 'B';
        } else if (user_salary >= 700 && user_salary < 800) {
            if (user_merit < 20) {
                to_return = 'B';
            } else {
                to_return = 'A';
            }
        }


        System.out.println(to_return);


        sc.close();
    }
}
