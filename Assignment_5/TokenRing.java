import java.util.Scanner;

public class TokenRing 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes : ");
        int n = sc.nextInt();
        System.out.println("Ring Initialized as : ");
        for(int i=0; i<n; i++)
        {
            System.out.print(i+ " ");
        }
        System.out.println();
        int cr;
        while(true)
        {
            System.out.println("Enter process ID that needs to use the critical section : ");
            cr = sc.nextInt();

            for(int token = 0; token < n; token++)
            {
                System.out.println("Token is at : " +  token);
                if(cr == token)
                {
                    System.out.println("Process ID "+token+" recieved access to the Critical Section");
                    System.out.println("Process ID "+token+" is using the Critical Section");
                    System.out.println("Process ID "+token+" passed the token to the next process");
                }
                else
                {
                    System.out.println("Process ID "+token+" does not need to access the Critical Section");
                    System.out.println("Process ID "+token+" passed the token to the next process");
                }
            }
        }   
    }
}
