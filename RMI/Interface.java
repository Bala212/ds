import java.rmi.*;

public interface Interface extends Remote {
    public double add(double n1, double n2) throws RemoteException;
}