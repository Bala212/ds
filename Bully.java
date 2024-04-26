import java.util.Scanner;

public class Bully {

    int n, cr;
    boolean check[];

    public Bully(int num) {
        n = num;
        check = new boolean[n + 1];
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

    void algo(int num) {
        if (check[num]) {
            cr = num;
            boolean f = true;
            for (int i = num + 1; i <= n && f; i++) {
                System.out.println("Sending message from " + num + " to " + i);

                if (check[i]) {
                    f = false;
                    System.out.println("----- As P" + i + " is up, start election from " + i + " -----");
                    algo(i);
                }
            }
        } else
            System.out.println("!!!!!P" + num + " is down!!!!!");
    }

    public static void main(String[] args) {
        int n, id, choice;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of processes: ");
        n = sc.nextInt();

        Bully bully = new Bully(n);

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
                    bully.algo(id);
                    bully.display();
                    break;
                case 2:
                    bully.display();
                    break;
                case 3:
                    System.out.print("Enter the process number which you want to up:- ");
                    id = sc.nextInt();
                    bully.up(id);
                    break;
                case 4:
                    System.out.print("Enter the process number which you want to down:- ");
                    id = sc.nextInt();
                    bully.down(id);
                    break;
                default:
                    System.out.print("Please enter valid input!");
            }
        }

    }

}