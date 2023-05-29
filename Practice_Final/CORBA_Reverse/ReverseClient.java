import java.util.Scanner;

import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import ReverseModule.Reverse;
import ReverseModule.ReverseHelper;

public class ReverseClient 
{
    public static void main(String args[])
    {
        try
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            org.omg.CORBA.Object obRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(obRef);
            Reverse ReverseImplementation = ReverseHelper.narrow(ncRef.resolve_str("Reverse"));

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the string : ");
            String s = sc.nextLine();
            System.out.println("Reversed string is : "+ ReverseImplementation.reverse_string(s));
            sc.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
