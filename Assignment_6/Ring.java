import java.util.Scanner;

public class Ring 
{
    int coordinator;
    boolean[] process_states;
    int n;

    Ring(int n)
    {
        this.n = n;
        this.coordinator = n-1;
        this.process_states = new boolean[n];
        for(int i=0; i<n; i++)
        {
            this.process_states[i] = true;
        }
        System.out.println("Ring has been initialized \nCurrent co-ordinator is : "+coordinator);
        displayRing();
    }

    void activate(int x)
    {
        if(x>=0 && x<n)
        {
            if(process_states[x])
            {
                System.out.println("Process already active");
            }
            else
            {
                this.process_states[x] = true;
                System.out.println("Process activated");
            }
        }
        else
        {
            System.out.println("Enter a valid process");
        }
    }

    void deactivate(int x)
    {
        if(x>=0 && x<n)
        {
            if(!process_states[x])
            {
                System.out.println("Process already inactive");
            }
            else
            {
                this.process_states[x] = false;
                System.out.println("Process deactivated");
            }
        }
        else
        {
            System.out.println("Enter a valid process");
        }
    }

    void displayRing()
    {
        for(int i=0; i<n; i++)
        {
            System.out.println(i+" | "+(process_states[i]?"active":"inactive"));
        }
    }

    void election(int x)
    {
        int temp = -1;
        if(x>=0 && x<n && process_states[x])
        {
            int token = x+1;
            while(token != x)
            {
                System.out.println("Election Token at : "+token);
                if(process_states[token])
                {
                    System.out.println("Response recieved from : "+token);
                    if(token > temp)
                    {
                        temp = token;
                    }
                }
                token++;
                if(token == n)
                {
                    for (int i=0; i<=x; i++)
                    {
                        if(process_states[i])
                        {
                            token = i;
                            break;
                        }
                    }
                }
            }
            this.coordinator = temp;
            System.out.println("New Co-ordintor is : "+ coordinator);
        }
        else
        {
            System.out.println("Enter a valid process");
        }
    }
    
    void ping(int x)
    {
        if(x>=0 && x<n && process_states[x])
        {
            if(process_states[coordinator])
            {
                System.out.println("Response Recieved from "+coordinator);
            }
            else
            {
                election(x);
            }
        }
        else
        {
            System.out.println("Enter a valid process");
        }
    }

    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes : ");
        int n = sc.nextInt();
        int c,x;
        Ring r = new Ring(n);
        while(true)
        {
            System.out.println("=============================");
            System.out.println("1. Activate a Process");
            System.out.println("2. DeActivate a Process");
            System.out.println("3. View Ring");
            System.out.println("4. Election");
            System.out.println("5. Ping Co-ordinator");
            System.out.println("=============================");
            System.out.println("Enter Choice :");
            c =  sc.nextInt();
            if(c == 1)
            {
                System.out.println("Enter Process ID:");
                x =  sc.nextInt();
                r.activate(x);
            }
            else if(c == 2)
            {
                System.out.println("Enter Process ID:");
                x =  sc.nextInt();
                r.deactivate(x);
            }
            else if(c == 3)
            {
                r.displayRing();;
            }
            else if(c == 4)
            {
                System.out.println("Enter Process ID that will call the election :");
                x =  sc.nextInt();
                r.election(x);
            }
            else if(c == 5)
            {
                System.out.println("Enter Process ID that will ping the coordinator :");
                x =  sc.nextInt();
                r.ping(x);
            }
            else
            {
                System.out.println("Invalid Choice");
            }
        }

    }
}
