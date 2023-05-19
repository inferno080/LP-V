// Implements the AddServerInterface

import java.rmi.*;
import java.rmi.server.*;

public class AddServerImplementation extends UnicastRemoteObject implements AddServerInterface 
{

    public AddServerImplementation() throws RemoteException{}
    
    public double add(double d1, double d2) throws RemoteException
    {
        return d1+d2;
    }
} 