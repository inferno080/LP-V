// AddServerInterface.java, defines the remote interface that is provided by the server. 
// It contains one method that accepts two doublearguments and returns their sum.

import java.rmi.*;

public interface AddServerInterface extends Remote 
{
    double add(double d1, double d2) throws RemoteException;
}  