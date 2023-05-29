import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddServerImplementation extends UnicastRemoteObject implements AddServerInterface
{
    AddServerImplementation() throws RemoteException{};
    
    public double add(double d1, double d2)
    {
        return d1+d2;
    }
}
