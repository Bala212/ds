
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf{
    private LocalTime localTime;
    ServerImpl(LocalTime localTime) throws RemoteException{
        this.localTime = localTime;
    }

    public LocalTime getTime() throws RemoteException{
        return this.localTime;
    }

    public void adjustTime(LocalTime serverTime) throws RemoteException{

       this.localTime = serverTime; 
       long diff = localTime.toNanoOfDay()- serverTime.toNanoOfDay();
        System.out.println("Updated Time is "+this.localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("Diff is" + diff);

    }
}
