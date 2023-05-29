import java.rmi.Naming;

public class AddClient 
{
    public static void main(String args[]) 
    {
        try
        {
            String url = "rmi://" + args[0] + "/AddServer";
            double d1 = Double.valueOf(args[1]).doubleValue();
            double d2 = Double.valueOf(args[2]).doubleValue();
            AddServerInterface x = (AddServerInterface)Naming.lookup(url);
            System.out.println("The Answer is : "+ x.add(d1, d2));
        }
        catch (Exception e)
        {
            System.out.println("Exception : "+ e);
        }
    }
}
