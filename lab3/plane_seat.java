public class plane_seat {
    private int seat_id;
    private boolean assigned = false;
    private int customer_id;
    static int total_number = 0;

    public plane_seat(int seat_id) {
        this.seat_id = seat_id;
        total_number++;
    }

    public static plane_seat copy(plane_seat to_copy) {
        plane_seat to_return = new plane_seat(to_copy.seat_id);
        if (to_copy.is_occupied()) {
            to_return.assign(to_return.get_customer_id());
        }

        return to_return;
    }

    public int get_seat_id() {
        return this.seat_id;
    }

    public int get_customer_id() {
        return this.customer_id;
    }
    
    public boolean is_occupied() {
        return this.assigned;
    }

    public void assign(int customer_id) {
        this.customer_id = customer_id;
        this.assigned = true;
    }

    public void unassign() {
        this.customer_id = -99;
        this.assigned = false;
    }

    public static int get_total() {
        return total_number;
    }
}