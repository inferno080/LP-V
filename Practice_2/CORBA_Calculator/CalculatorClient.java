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
            org.omg.CORBA.ORB orb =  org.omg.CORBA.ORB.init(args, null);
            org.omg.CORBA.Object obRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(obRef);
            CalculatorImplementation = CalculatorHelper.narrow(ncRef.resolve_str("Calculator"));
            
            Scanner sc = new Scanner(System.in);
            int num1, num2, c;
            while(true)
            {
                System.out.println("Enter Number 1 :");
                num1 = sc.nextInt();
                System.out.println("Enter Number 2 :");
                num2 = sc.nextInt();
                System.out.println("================");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("5. Exit");
                System.out.println("===============");
                System.out.println("Enter Choice  :");
                c = sc.nextInt();
                if(c == 1)
                {
                    System.out.println("Answer is : "+ CalculatorImplementation.add(num1,num2));
                }
                else if(c == 2)
                {
                    System.out.println("Answer is : "+ CalculatorImplementation.sub(num1,num2));
                }
                else if(c == 3)
                {
                    System.out.println("Answer is : "+ CalculatorImplementation.mul(num1,num2));
                }
                else if(c == 4)
                {
                    System.out.println("Answer is : "+ CalculatorImplementation.div(num1,num2));
                }
                else if(c == 5)
                {
                    System.out.println("Thank you for using CORBA Calculator !");
                    sc.close();
                    break;
                }
                else
                {
                    System.out.println("Invalid Choice");
                }
            }

        }
        catch (Exception e)
        {   
            e.printStackTrace();
        }
    }

}
