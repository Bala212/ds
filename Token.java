import java.util.Scanner;

public class Token {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        int nodes = sc.nextInt();

        for (int i = 0; i < nodes; i++) {
            System.out.print(i + " ");
        }

        System.out.println(0);

        int token = 0;

        while (true) {
            System.out.println("Enter the sender node: ");
            int sender = sc.nextInt();

            System.out.println("Enter the receiver node: ");
            int receiver = sc.nextInt();

            System.out.println("Passing the token to the sender: ");
            for (int i = token; i != sender; i = (i + 1) % nodes) {
                System.out.print(i + " -> ");
            }

            System.out.println(sender);

            token = sender;

            System.out.println("Sender node(" + sender + ") recieved the token");

            System.out.println("Sending message from Sender to Reciever: ");

            for (int i = sender; i != receiver; i = (i + 1) % nodes) {
                System.out.println("Node " + i + " sends message to node " + (i + 1) % nodes);
            }

            System.out.println("Message recieved by Reciever node(" + receiver + ")");
        }

    }
}