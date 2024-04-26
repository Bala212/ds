import java.rmi.Naming;

public class Server {
    public static void main(String[] args) {
        try {
            Implementation obj = new Implementation();
            Naming.rebind("Server", obj);
            System.out.println("Server started...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
