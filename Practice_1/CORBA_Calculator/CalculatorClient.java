import java.util.Scanner;

import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import CalculatorModule.Calculator;
import CalculatorModule.CalculatorHelper;

public class CalculatorClient 
{
    public static void main(String args[])
    {
        Calculator CalculatorImplementation = null;
        try
        {

            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            CalculatorImplementation = CalculatorHelper.narrow(ncRef.resolve_str("Calculator"));
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter First Number : ");
            int x = sc.nextInt();
            System.out.println("Enter Second Number : ");
            int y = sc.nextInt();
            System.out.println("Answer is : "+ CalculatorImplementation.add(x, y));
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
