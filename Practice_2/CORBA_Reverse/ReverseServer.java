import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import ReverseModule.Reverse;

public class ReverseServer
{
	public static void main(String[] args){
		try
        {
			org.omg.CORBA.ORB orb=org.omg.CORBA.ORB.init(args,null);
			POA rootPOA=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.the_POAManager().activate();
			ReverseImplementation x=new ReverseImplementation();
			org.omg.CORBA.Object ref=rootPOA.servant_to_reference(x);
			Reverse h_ref=ReverseModule.ReverseHelper.narrow(ref);
			org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
			NamingContextExt ncRef=NamingContextExtHelper.narrow(objRef);
			NameComponent path[]=ncRef.to_name("Reverse");
			ncRef.rebind(path,h_ref);
			System.out.println("Server up and running ...");
			orb.run();
		} 
        catch (Exception e)
        {
            e.printStackTrace();
		}	
	}
}