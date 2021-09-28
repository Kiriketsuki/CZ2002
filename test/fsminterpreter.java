import java.util.*;
import java.util.stream.Collector;
// import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;
// import java.nio.*;
import java.nio.file.*;

public class fsminterpreter {

    private static String state;
    private static String output = "";
    public static void main(String[] args) throws FileNotFoundException{
        
        if (args.length != 1) { // user has not provided arguments
            System.out.println("\n Usage: java fsminterpreter <fsmdescription> <input \n"); // error message is printed out
            System.exit(0);
        }
        
        // System.out.println(args.length);
        // System.out.println(args[0]);
        String fsmName = args[0];

        Scanner scanner = new Scanner(System.in);
        char[] user_input = (scanner.next()).toCharArray();

        scanner.close();

        String[][] table = create_table(fsmName);
        String initial_state = table[0][0];

        // sort table
        Arrays.sort(table, (a,b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));
        HashSet<String> available_inputs = get_inputs(table);

        // verification
        if (!verify_table(table)) {
            System.out.print("Bad description");
            return;
        }
        

        // start
        state = initial_state;

        for (char input: user_input) {
            String temp = Character.toString(input);
            if (!available_inputs.contains(temp)) {
                System.out.format("Bad input");
                return;
            }

            // loop through table till you get to state
            for (int i = 0; i < table.length; i++) {
                if (table[i][0].equals(state)) {
                    if (table[i][1].equals(temp)) {
                        System.out.format("%s", table[i][2]);
                        state = table[i][3];
                        break;
                    }
                }
            }
        }
    }

    public static void print_table(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j= 0; j < 4; j++) {
                System.out.format("%s ", table[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean verify_table(String[][] table) {
        // assume table is sorted
        boolean to_return = true;
        HashSet<String> available_inputs = get_inputs(table);
        int no_of_inputs = available_inputs.size();
        HashSet<String> available_states = get_states(table);
        int no_of_states = available_states.size();
        HashSet<String> transition_states = get_transition_states(table);

        // check if states are valid aka numeric
        for (int i = 0; i < table.length; i++) {
            if (!is_numeric(table[i][0]) || !is_numeric(table[i][3])) {
                to_return = false;
                return to_return;
            }
        }

        // check if table size matches inputs and states
        if (table.length != no_of_inputs * no_of_states) {
            to_return = false;
            return to_return;
        }

        // check if you can only transition into states that you can transition from
        to_return = available_states.equals(transition_states);

        // check if each available state appears no of inputs times
        // String prev = table[0][0];
        // int counter = 1;
        // int prev_counter = 1;

        // for (int i = 0; i < table.length; i++) {
        //     String curr = table[i][0];
        //     if (curr.equals(prev)) {
        //         counter++;
        //     } else {
        //         prev_counter = counter;
        //         counter = 1;
        //     }
        //     prev = curr;

        //     if (counter > no_of_inputs || prev_counter < no_of_inputs) {
        //         to_return = false;
        //         return to_return;
        //     }
        // }

        return to_return;
    }

    public static boolean verify_inputs(char[] inputs, HashSet<String> available_inputs) {
        boolean to_return = true;
        for (char curr : inputs) {
            if (!available_inputs.contains(Character.toString(curr))) {
                to_return = false;
                return to_return;
            }
        }
        return to_return;
    }

    public static HashSet<String> get_inputs(String[][] table) {
        // count unique
        HashSet<String> to_return = new HashSet<String>();
        for (int i =  0; i < table.length; i++) {
            to_return.add(table[i][1]);
        }

        return to_return;
    }

    public static HashSet<String> get_states(String[][] table) {
        // count unique
        HashSet<String> to_return = new HashSet<String>();
        for (int i = 0; i < table.length; i++) {
            to_return.add(table[i][0]);
        }

        return to_return;
    }

    public static HashSet<String> get_transition_states(String[][] table) {
        HashSet<String> to_return = new HashSet<String>();
        for (int i = 0; i < table.length; i++) {
            to_return.add(table[i][3]);
        }

        return to_return;
    }

    public static boolean is_numeric(String to_check) {
        if (to_check == null) {
            return false;
        }

        try {
            int test = Integer.parseInt(to_check);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
    public static void print_state() {
        System.out.println(state);
    }

    public static String[][] create_table(String filename) throws FileNotFoundException{
        String[][] to_return;

        try {
            List<String> non_empty = Files.lines(Paths.get(filename)).filter(line -> line.length() > 0).collect(Collectors.toList());
            int rows = non_empty.size();
            to_return = new String[rows][4];

            for (int i = 0; i < rows; i++) {
                to_return[i] = non_empty.get(i).split("//s+");
            }
            return to_return;
        
        } catch (Exception e) {
            throw new FileNotFoundException("");
        }
    }
}