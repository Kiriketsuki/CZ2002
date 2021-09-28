import java.util.*;

public class plane_app {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        plane new_plane = new plane();
        int choice = 1;
        display();

        while (choice != 7) {
            System.out.println("Enter the number of your choice");
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    new_plane.show_num_empty_seats();
                    break;
                case 2:
                    new_plane.show_empty_seats();
                    break;
                case 3:
                    new_plane.show_assigned_sets(true);
                    break;
                case 4:
                    new_plane.show_assigned_sets(false);
                    break;
                case 5:
                    System.out.println("Assigning Seat...");
                    System.out.format("Please enter SeatID: ");
                    int seat_id = scanner.nextInt();
                    System.out.format("Please enter Customer ID: ");
                    int cust_id = scanner.nextInt();
                    System.out.println();
                    new_plane.assign_seat(seat_id, cust_id);
                    break;
                case 6:
                    System.out.format("Enter SeatID to unassign customer from:");
                    seat_id = scanner.nextInt();
                    System.out.println();
                    new_plane.unassign_seat(seat_id);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    display();
                    break;
            }
        }
        scanner.close();
    }

    public static void display() {
        System.out.println("(1) Show number of empty seats");
        System.out.println("(2) Show the list of empty seats");
        System.out.println("(3) Show the list of seat assignments by seat ID");
        System.out.println("(4) Show the list of seat assignments by customer ID");
        System.out.println("(5) Assign a customer to a seat");
        System.out.println("(6) Remove a seat assignment");
        System.out.println("(7) Exit");
    }
}
