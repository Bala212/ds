import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class Client {
    public static void main(String[] args) throws IOException {
        // Connect to the server
        // Server IP address (localhost for testing on local machine)
        // Server port
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected to server: " + socket);

        // Create input and output streams for communication with the server
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Generate and send multiple local times to server (at least 3)
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int localTime = random.nextInt(24 * 60); // Generate random local time within a day (in minutes)
            System.out.println("Local time sent to server: " + localTime);
            dos.writeInt(localTime);
        }

        // Receive synchronized time from server
        int synchronizedTime = dis.readInt();
        System.out.println("Received synchronized time from server: " + synchronizedTime);

        // Close streams and socket
        dis.close();
        dos.close();
        socket.close();
    }
}