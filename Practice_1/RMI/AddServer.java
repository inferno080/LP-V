import java.rmi.Naming;

public class AddServer 
{
    public static void main(String args[]) 
    {
        try
        {
            AddServerImplementation x = new AddServerImplementation();
            Naming.rebind("AddServer", x);
        }
        catch (Exception e)
        {
            System.out.println("Exception : "+ e);
        }
    }
}
