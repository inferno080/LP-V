import java.rmi.*;

public class AddClient
{
    public static void main(String args[]) 
    {
        try
        {
            String addServerURL = "rmi://" + args[0] +"/AddServer";
            double d1 = Double.valueOf(args[1]).doubleValue();
            double d2 = Double.valueOf(args[2]).doubleValue();
            AddServerInterface addServerIntf = (AddServerInterface)Naming.lookup(addServerURL);
            System.out.println(d1 + " + " + d2 + " = " + addServerIntf.add(d1, d2));
        }
        catch (Exception e)
        {
            System.out.println("Exception : "+ e);            
        }
    }
}
 