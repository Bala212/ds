import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String url = "rmi://localhost/Server";
            Interface obj = (Interface) Naming.lookup(url);

            System.out.println("Enter the first Number:- ");
            int n1 = sc.nextInt();

            System.out.println("Enter the second Number:- ");
            int n2 = sc.nextInt();

            System.out.println("Addition of " + n1 + " and " + n2 + " is " + obj.add(n1, n2));

            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
