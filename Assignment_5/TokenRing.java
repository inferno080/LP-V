import java.util.Scanner;

public class TokenRing 
{
    public static void main(String args[]) throws Throwable
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes : ");
        int n = sc.nextInt();
        System.out.println("Initializing ring ...");
        for (int i=0; i<n; i++)
        {
            System.out.print(i + "\t");
        }
        System.out.println();
        boolean message_pass = false;
        System.out.println("Enter Sender : ");
        int sender = sc.nextInt();
        System.out.println("Enter Reciever : ");
        int reciever = sc.nextInt();
        for(int token =0; token<=n; token++)
        {
            System.out.println("Token at Process : " + token);
            if(token == sender)
            {
                if(!message_pass)
                {
                    message_pass = true;
                    System.out.println("Message Sent");
                }
                else
                {
                    System.out.println("Reciever not found");
                    return;
                }
            }
            if(token == reciever)
            {
                if(message_pass)
                {
                    message_pass = false;
                    System.out.println("Message Recieved");
                    break;
                }
            }
            if(token == n-1)
            {
                token = -1;
            }
        }
    }
}
