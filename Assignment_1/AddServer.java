//AddServer.java, contains the main program for the server machine. 
//Its primary function is to update the RMI registry on that machine.

import java.rmi.*;

public class AddServer
{
    public static void main(String args[])
    {
        try
        {
            AddServerImplementation addServerImpl = new AddServerImplementation();
            Naming.rebind("AddServer", addServerImpl);
        }
        catch(Exception e)
        {
            System.out.println("Exception : "+ e);
        }
    }
}
  