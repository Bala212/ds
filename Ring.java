import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ring {

    int n, cr;
    boolean check[];

    // An ArrayList to keep track of the process IDs involved in the election
    // process.
    ArrayList<Integer> arr;

    public Ring(int num) {
        n = num;
        check = new boolean[n + 1];
        arr = new ArrayList<>();
        cr = n;

        for (int i = 1; i <= n; i++) {
            check[i] = true;
            System.out.println("P" + i + " created");
        }
    }

    void up(int num) {
        if (check[num])
            System.out.println("!!!!!P" + num + " is already up!!!!!");
        else {
            check[num] = true;
            System.out.println("-----P" + num + " is up now-----");
        }
    }

    void down(int num) {
        if (check[num] = false)
            System.out.println("!!!!!P" + num + " is already down!!!!!");
        else {
            check[num] = false;
            System.out.println("-----P" + num + " is down now-----");
        }

    }

    void display() {
        System.out.println("----------Displaying Processes and their status----------");
        for (int i = 1; i <= n; i++) {
            if (check[i])
                System.out.println("P" + i + " is up.");
            else
                System.out.println("P" + i + " is down.");
        }

        System.out.println("-----P" + cr + " is co-ordinator-----.");
    }

    void displayCor() {
        System.out.println("-----P" + cr + " is the Co-ordinator now-----");
    }

    void displayArr() {
        System.out.print("[ ");
        for (Integer val : arr) {
            System.out.print(val + " ");
        }
        System.out.println("]");
    }

    void algo(int num) {
        // Check if the current process is up
        if (check[num]) {
            // Add the current process to the list
            arr.add(num);

            // Display the current list of processes
            System.out.println("P" + num + " sending the following list:-");
            displayArr();

            // Initialize a temporary variable for iterating over processes
            int temp = num + 1;

            // Loop until we reach back to the starting process
            while (temp != num) {
                // Check if the process at index 'temp' is up
                if (check[temp]) {
                    // Add the process to the list
                    arr.add(temp);
                    // Display the updated list of processes
                    System.out.println("P" + temp + " sending the following list:-");
                    displayArr();
                } else if (temp != 0)
                    // If the process is down, print a message
                    System.out.println("!!!! P" + temp + " is down!!!!");

                // Move to the next process in a circular manner
                temp = (temp + 1) % (n + 1); // n+1 because I am using 1 based indexing
            }

            // Select the process with the highest ID from the list as the coordinator
            cr = Collections.max(arr);

            // Display the selected coordinator
            System.out.println("----- P" + num + " selected the P" + cr + " as co-ordinator -----");

            // Clear the list for the next use
            arr.clear();

        } else
            // If the current process is down, print a message
            System.out.println("!!!!!P" + num + " is down!!!!!");
    }

    public static void main(String[] args) {
        int n, id, choice;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of processes: ");
        n = sc.nextInt();

        Ring ring = new Ring(n);

        while (true) {
            System.out.println("------------------------------");
            System.out.println("1. Run the Election Algorithm");
            System.out.println("2. Display processes");
            System.out.println("3. Up the process");
            System.out.println("4. Down the process");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the process number which will perform election:- ");
                    id = sc.nextInt();
                    ring.algo(id);
                    ring.display();
                    break;
                case 2:
                    ring.display();
                    break;
                case 3:
                    System.out.print("Enter the process number which you want to up:- ");
                    id = sc.nextInt();
                    ring.up(id);
                    break;
                case 4:
                    System.out.print("Enter the process number which you want to down:- ");
                    id = sc.nextInt();
                    ring.down(id);
                    break;
                default:
                    System.out.print("Please enter valid input!");
            }
        }

    }

}