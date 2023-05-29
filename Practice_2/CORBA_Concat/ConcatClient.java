import java.util.Scanner;

import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import ConcatModule.Concat;
import ConcatModule.ConcatHelper;

public class ConcatClient 
{
    public static void main(String args[]) 
    {
        Concat ConcatImplementation = null;
        try
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
            org.omg.CORBA.Object obRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(obRef);
            ConcatImplementation = ConcatHelper.narrow(ncRef.resolve_str("Concat"));


            Scanner sc = new Scanner(System.in);
            String s1, s2;
            System.out.println("Enter String 1 :");
            s1 = sc.nextLine();
            System.out.println("Enter String 2 :");
            s2 = sc.nextLine();
            System.out.println("Result : "+ ConcatImplementation.concat_strings(s1, s2));
            sc.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
