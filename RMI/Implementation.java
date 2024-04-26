
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Implementation extends UnicastRemoteObject implements Interface {
    public Implementation() throws RemoteException {
    };

    public double add(double n1, double n2){
        return n1 + n2;
    }
}
