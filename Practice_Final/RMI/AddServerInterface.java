import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddServerInterface extends Remote
{
    public double add(double d1, double d2) throws RemoteException;
}