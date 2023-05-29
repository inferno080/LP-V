import java.util.Scanner;

public class Bully 
{
    int coordinator;
    int n;
    boolean[] process_states;

    Bully(int n)
    {
        this.n = n;
        this.process_states = new boolean[n];
        for(int i=0; i<n; i++)
        {
            process_states[i] = true;
        }
        System.out.println("Processes Created Successfully");
        this.coordinator = n-1;
        System.out.println(coordinator+" is coordinator");
        display();
    }

    void display()
    {
        System.out.println("| Process | Active |" );
        for(int i=0; i<n; i++)
        {
            System.out.println("|    "+i+ "    | "+process_states[i]);
        }
    }

    void up(int x)
    {
        if(x>=0 && x<n)
        {
            if(process_states[x])
                System.out.println("Process is already active");
            else
            {
                process_states[x] = !process_states[x];
                System.out.println("Process actived");
                System.out.println("Process initiated election");
                election(x);
                
            }
        }
        else
        {
            System.out.println("Enter a Valid Process ID");
        }
    }

    void down(int x)
    {
        if(x>=0 && x<n)
        {
            if(!process_states[x])
                System.out.println("Process is already inactive");
            else
            {
                process_states[x] = !process_states[x];
                System.out.println("Process deactived");
            }
        }
        else
        {
            System.out.println("Enter a Valid Process ID");
        }
    }

    void ping(int x)
    {
        if(x>=0 && x<n && process_states[x])
        {
            if(process_states[coordinator])
            {
                System.out.println("Message Sent");
            }
            else
            {
                election(x);
                System.out.println("Message Sent");
            }
        }
        else
        {
            System.out.println("Enter a Valid Process ID");
        }
    }

    void election(int x)
    {
        if(x>=0 && x<n && process_states[x])
        {
            int temp = -1;
            if(x != n)
            {
                int token = x+1;
                while(token != n)
                {
                    System.out.println("Election message sent to : "+ token);
                    if(process_states[token])
                    {
                        System.out.println("Alive Message sent by : "+ token);
                        if(temp < token)
                        {
                            temp = token;
                        }
                    }
                    token ++;
                }
            } 
            else
                temp = x;
            System.out.println(temp+" won the election");
            this.coordinator = temp;
        
        }
        else
        {
            System.out.println("Enter a Valid Process ID");
        }
    }

    public static void main(String args[]) 
    {
        int n,c,x;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Processes : ");
        n = sc.nextInt();
        Bully r = new Bully(n);
        while(true)
        {
        System.out.println("============================");
        System.out.println("1. Activate a Process");
        System.out.println("2. Deactivate a Process");
        System.out.println("3. View Processes");
        System.out.println("4. Election");
        System.out.println("5. Ping Coordinator");
        System.out.println("============================");
        System.out.println("Enter Choice :");
        c = sc.nextInt();
        if(c == 1)
        {
            System.out.println("Enter Process ID :");
            x = sc.nextInt();
            r.up(x);
        }
        else if(c==2)
        {
            System.out.println("Enter Process ID :");
            x = sc.nextInt();
            r.down(x);
        }
        else if(c==3)
        {
            r.display();
        }
        else if(c==4)
        {
            System.out.println("Enter Election Initiator :");
            x = sc.nextInt();
            r.election(x);
        }
        else if(c==5)
        {
            System.out.println("Enter Process ID :");
            x = sc.nextInt();
            r.ping(x);
        }
        else
        {
            System.out.println("Invalid Option");
        }
        }
        
    }
}
