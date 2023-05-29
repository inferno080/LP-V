import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CalculatorModule.Calculator;
import CalculatorModule.CalculatorHelper;

public class CalculatorServer 
{
    public static void main(String args[]) 
    {
        try
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();
            CalculatorImplementation x = new CalculatorImplementation();
            org.omg.CORBA.Object ref = rootPoa.servant_to_reference(x);
            Calculator h_ref = CalculatorHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent path[] = ncRef.to_name("Calculator");
            ncRef.rebind(path, h_ref);
            System.out.println("Server Listening and Waiting ... ");
            orb.run();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
