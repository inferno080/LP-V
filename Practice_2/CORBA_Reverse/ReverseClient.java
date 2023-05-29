import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import ReverseModule.Reverse;
import ReverseModule.ReverseHelper;

public class ReverseClient
{
    public static void main(String args[]) 
    {
        Reverse ReverseImplementation =  null;
        try
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            org.omg.CORBA.Object ob = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(ob);
            ReverseImplementation = ReverseHelper.narrow(ncRef.resolve_str("Reverse"));
            String s = "Hello Server";
            System.out.println(ReverseImplementation.reverse_string(s));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}