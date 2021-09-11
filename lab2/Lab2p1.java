import java.util.*;

public class Lab2p1 {
    public static void main(String[] args) {
        int choice;
        int m;
        int n;
        int output;
        long why_did_you_make_this_long;
        long output_also_long_for_what;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Perform the following methods:"); 
            System.out.println("1:  multiplication test"); 
            System.out.println("2:  quotient using division by subtraction"); 
            System.out.println("3:  remainder using division by subtraction"); 
            System.out.println("4:  count  the  number of digits"); 
            System.out.println("5:  position of a digit"); 
            System.out.println("6:  extract all odd digits"); 
            System.out.println("7:  quit"); 
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    mulTest();
                    break;
                case 2:
                    System.out.println("Enter digits m and n");
                    m = sc.nextInt();
                    n = sc.nextInt();
                    output = divide(m, n);
                    System.out.format("%d/%d is %d\n", m, n, output);
                    break;
                case 3:
                    System.out.println("Enter digits m and n");
                    m = sc.nextInt();
                    n = sc.nextInt();
                    output = modulus(m, n);
                    System.out.format("%d %% %d is %d\n", m, n, output);
                    break;
                case 4:
                    System.out.println("Enter digit n");
                    n = sc.nextInt();
                    output = count_digits(n);
                    if (output == -1) {
                        System.out.println("Enter a positive input");
                    } else {
                        System.out.format("%d has %d number of digits\n", n, output);
                    }
                    break;
                case 5:
                    System.out.println("Enter number n and position of digit to find");
                    n = sc.nextInt();
                    m = sc.nextInt();
                    output = position(n, m);
                    if (output == -1) {
                        System.out.println("Digit not found");
                    } else {
                        System.out.format("%d is found at position %d of number %d\n", m, output, n);
                    }
                    break;
                case 6:
                    System.out.println("Enter number n");
                    why_did_you_make_this_long = sc.nextLong();
                    output_also_long_for_what = extract_odd_digits(why_did_you_make_this_long);
                    if (output_also_long_for_what == -2) {
                        System.out.println("Enter a positive number");
                    } else if (output_also_long_for_what == -1) {
                        System.out.println("No odd numbers");
                    } else {
                        System.out.format("%d\n", output_also_long_for_what);
                    }

                    break;
                case 7:
                    break;
            }
        } while (choice < 7);

        sc.close();
    }

    public static void mulTest() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int to_print = 0;
        for (int i = 0; i < 5; i++){
            int a = rand.nextInt(10);
            int b = rand.nextInt(10);
            
            System.out.format("How much is %d times %d?\n", a, b);
            int answer = sc.nextInt();
            if (answer == a*b) {
                to_print++;
            }
        }
        
        System.out.format("%d answers out of 5 are correct\n",  to_print);
        sc.close();
    }

    public static int divide(int m, int n) {
        int to_return = 0;

        if (m < n) {
            return to_return;
        }

        if (m == n) {
            to_return = 1;
            return to_return;
        }

        while (m > n) {
            m -= n;
            to_return++;
        }

        return to_return;
    }

    public static int modulus(int m, int n) {
        int to_return = 0;

        if (m == n) {
            return to_return;
        }

        if (m < n) {
            return m;
        }

        while (m > n) {
            m -= n;
        }

        to_return = m;
        return to_return;
    }

    public static int count_digits(int n) {
        if (n < 0) {
            return -1;
        }

        int to_return = 0;

        while (n > 0) {
            n /= 10;
            to_return++;
        }

        return to_return;
    }

    // public static int position(int n, int digit) {
    //     int to_return = -1;
    //     char digit_char = (char) digit;
    //     digit_char += '0';
    //     String n_string = String.valueOf(n);
    //     int string_len = n_string.length();

    //     for (int i = 0; i < string_len; i++) { 
    //         if (n_string.charAt(i) == digit_char) {
    //             to_return = i + 1;
    //             return to_return;
    //         }
    //     }

    //     return to_return;
    // }

    public static int position(int n, int digit) {
        int to_return = 0;
        int compare = 0;
        while (n > 0) {
            compare = n % 10;
            n /= 10;
            to_return++;
            if (compare == digit) {
                return to_return;
            }
        }

        return -1;
    }

    public static long extract_odd_digits(long n) {
        long to_return = -2;
        if (n < 0) {
            return to_return;
        } else {
            to_return = 0;
        }

        String n_string = String.valueOf(n);
        for (int i = 0; i < n_string.length(); i++) {
            int temp_digit = Character.getNumericValue(n_string.charAt(i));
            if (temp_digit % 2 == 1) {
                to_return += temp_digit;
                to_return *= 10;
            }
        }

        if (to_return == 0) {
            to_return -= 1;
        } else {
            to_return /= 10;
        }

        return to_return;
    }
}
