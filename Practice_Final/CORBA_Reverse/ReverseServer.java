import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import ReverseModule.Reverse;
import ReverseModule.ReverseHelper;

public class ReverseServer 
{
    public static void main(String args[])
    {
        try
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            ReverseImplementation x = new ReverseImplementation();
            org.omg.CORBA.Object ob = rootPOA.servant_to_reference(x);
            Reverse h_ref = ReverseHelper.narrow(ob);
            org.omg.CORBA.Object obRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(obRef);
            NameComponent path[] = ncRef.to_name("Reverse");
            ncRef.bind(path,h_ref);
            System.out.println("Server Up and Running ...");
            orb.run();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
}
