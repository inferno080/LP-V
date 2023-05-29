import java.util.concurrent.TimeUnit;

public class TokenRing
{
    int n;

    TokenRing(int n)
    {
        this.n = n;
        System.out.println("Ring Initialized as : ");
        for(int i=0; i<n; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    void startTokenPassing()
    {
        for(int token=0; token<n; token++)
        {
            System.out.println("Token is at : "+ token);
            System.out.println("Process "+ token + " has entered the Critical Section");
            try 
            {
                TimeUnit.MILLISECONDS.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            System.out.println("Process "+ token + " has exited the Critical Section");
            System.out.println("Process "+ token + " has passed the Token");

            if(token == n-1)
            {
                token = -1;
            }
        }   
    }

    public static void main(String args[])
    {
        TokenRing t = new TokenRing(8);
        t.startTokenPassing();
    }
}