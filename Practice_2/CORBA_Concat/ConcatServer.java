import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import ConcatModule.Concat;
import ConcatModule.ConcatHelper;

public class ConcatServer 
{
    public static void main(String args[]) 
    {
        try
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            ConcatImplementation x = new ConcatImplementation();
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(x);
            Concat href = ConcatHelper.narrow(ref);
            org.omg.CORBA.Object obRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(obRef);
            NameComponent path[] = ncRef.to_name("Concat");
            ncRef.rebind(path, href);
            System.out.println("Server is running ...");
            orb.run();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
