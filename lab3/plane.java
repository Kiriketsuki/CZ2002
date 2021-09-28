import java.util.*;
public class plane {
    // modify this to increase size of plane
    final int no_of_seats = 12;

    private plane_seat plane_seats[];
    private int num_empty_seats = no_of_seats;

    public plane() {
        this.plane_seats = new plane_seat[no_of_seats];
        for (int i = 0; i < no_of_seats; i++) {
            plane_seats[i] = new plane_seat(i+1);
        }
    }

    private plane_seat[] sort_seats() {
        // ascending order of customer_id
        // deep copy of plane_seats
        plane_seat[] to_return = new plane_seat[no_of_seats];

        
        // get list of customer_ids and seat id
        int[] customer_ids = new int[no_of_seats];

        for (int i = 0; i < plane_seats.length; i++) {
            if (plane_seats[i].is_occupied()) {
                customer_ids[i] = plane_seats[i].get_customer_id();
            } else {
                customer_ids[i] = plane_seats[i].get_seat_id() * 17 * 43; // 2 prime number
            }
        }

        // sort list of customer_ids
        Arrays.sort(customer_ids);

        // add seats to to_return
        for (int i = 0; i < customer_ids.length; i++) {
            if (customer_ids[i] % 17 == 0 && customer_ids[i] % 43 == 0) { // no customer
                // loop through current array
                for (int j = 0; j < plane_seats.length; j++) {
                    if (plane_seats[j].get_seat_id() == (customer_ids[i]/17)/43) {
                        to_return[i] = plane_seat.copy(plane_seats[j]);
                    }
                }
            } else {
                for (int j = 0; j < plane_seats.length; j++) {
                    if (plane_seats[j].get_customer_id() == customer_ids[i]) {
                        to_return[i] = plane_seat.copy(plane_seats[j]);
                        to_return[i].assign(plane_seats[j].get_customer_id());
                    }
                }
            }
        }

        return to_return;
    }

    public void show_num_empty_seats() {
        System.out.format("There are %d empty seats\n", num_empty_seats);
    }

    public void show_empty_seats() {
        if (this.num_empty_seats > 0) {
            System.out.format("The following seats are empty: \n");
            for (int i = 0; i < plane_seats.length; i++) {
                if (!plane_seats[i].is_occupied()) {
                    System.out.format("SeatID %d\n", plane_seats[i].get_seat_id());
                }
            }
        } else {
            System.out.println("No empty seats");
        }
    }

    public void show_assigned_sets(boolean by_seat_id) {
        if (by_seat_id) {
            System.out.format("The following seats are occupied: \n");
            for (int i = 0; i < plane_seats.length; i++) {
                if (plane_seats[i].is_occupied()) {
                    System.out.format("SeatID: %d is assigned to CustomerID %d\n", plane_seats[i].get_seat_id(), plane_seats[i].get_customer_id());
                }
            }
            System.out.println();
        } else {
            System.out.format("The following seats are occupied: \n");
            plane_seat[] temp = sort_seats();
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].is_occupied()) {
                    System.out.format("SeatID: %d is assigned to CustomerID: %d\n",temp[i].get_seat_id(), temp[i].get_customer_id());
                }
            }
        }
    }

    public void assign_seat(int seat_id, int cust_id) {
        if (seat_id > no_of_seats) {
            System.out.println("Invalid SeatID");
            return;
        }

        if (plane_seats[seat_id - 1].is_occupied()) {
            System.out.println("Seat already assigned to a customer");
        } else {
            plane_seats[seat_id - 1].assign(cust_id);
            // System.out.format("SeatID %d assigned to CustomerID %d\n", seat_id, cust_id);
            System.out.println("Seat Assigned!");
        }
        this.num_empty_seats--;
    }

    public void unassign_seat(int seat_id) {
        if (seat_id > no_of_seats) {
            System.out.println("Invalid SeatID");
            return;
        }

        if (!plane_seats[seat_id - 1].is_occupied()) {
            System.out.println("Seat already empty");
        } else {
            plane_seats[seat_id - 1].unassign();
            System.out.println("Seat Unassigned!");
            this.num_empty_seats++;
        }
    }
}