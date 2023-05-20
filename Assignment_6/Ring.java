import java.util.Scanner;

public class Ring {

    int n, inactive_count;
    int coordinator;
    boolean[] process_state;

    public Ring(int n)
    {
        this.n = n;
        this.inactive_count = 0;
        this.process_state = new boolean[n];
        for(int i=0; i<n; i++)
        {
            this.process_state[i] = true;
        }
        this.coordinator = n-1;
        System.out.println("All Ring members are active \nProcess "+(n-1)+ " is inital coordinator \n");
    }

    public void deactivate(int x)
    {
        if(x>=n || x<0)
        {
            System.out.println("Process doesn't exist");
            return;
        }

        if(process_state[x])
        {
            process_state[x] = !process_state[x];
            System.out.println("Process "+x+" deactivated");
            inactive_count += 1;
        }
        else
            System.out.println("Process already inactive");
        
    }

    public void activate(int x)
    {
        if(x>=n || x<0)
        {
            System.out.println("Process doesn't exist");
            return;
        }

        if(!process_state[x])
        {
            process_state[x] = !process_state[x];
            System.out.println("Process "+x+" activated");
            inactive_count += 1;
        }
        else
            System.out.println("Process already active");
    }
    
    public void viewRing()
    {
        for(int i=0; i<n; i++)
        {
            System.out.println("Process : "+ i + "   |   Status :" + process_state[i]);
        }
    }

    public void election(int x)
    {
        if(x < 0 || x >= n || !process_state[x])
        {
            System.out.println("Process does not exist or is down");
            return;
        }
        if(inactive_count == n)
        {
            System.out.println("All Members are inactive \n Aborting election process");
            this.coordinator = -1;
            return;
        }
        int current_coordinator = x;
        int token = x + 1;
        System.out.println("Election Initiator : "+ x);
        while(token != x)
        {
            System.out.println("Token is at :" + (token));
            if(process_state[token])
            {
                if(token>current_coordinator)
                {
                    current_coordinator = token;
                }
            }
            token++;
            while(!process_state[token])
            {
                token++;
                if(token >= n)
                {
                    token = 0;
                }
            }
        }
        System.out.println("Elected Co-ordinator :"+ current_coordinator);
        this.coordinator = current_coordinator;

    }

    public void pingCoordinator(int x)
    {
        if(x < 0 || x >= n || !process_state[x])
        {
            System.out.println("Process does not exist or is down");
            return;
        }
        if(!process_state[coordinator])
        {
            System.out.println("Co-ordinator is down \n Conducting Election ...");
            election(x);
        }
        System.out.println("Message Sent");
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n , c = 0, x;
        System.out.println("Enter Number of Processes : ");
        n = sc.nextInt();
        Ring ring = new Ring(n);
        while(c != 6)
        {

            System.out.println("=======================");
            System.out.println("1. Deactivate a process");
            System.out.println("2. Activate a process");
            System.out.println("3. View Ring");
            System.out.println("4. Election");
            System.out.println("5. Ping Coordinator");
            System.out.println("========================");
            System.out.println("Enter Choice : ");
            c = sc.nextInt();
            switch(c)
            {
                case 1:
                {
                    System.out.println("Enter Process ID : ");
                    x = sc.nextInt();
                    ring.deactivate(x);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter Process ID : ");
                    x = sc.nextInt();
                    ring.activate(x);
                    break;
                }
                case 3:
                {
                    ring.viewRing();
                    break;
                }
                case 4:
                {
                    System.out.println("Enter Process ID for election initiator: ");
                    x = sc.nextInt();
                    ring.election(x);
                    break;
                }
                case 5:
                {
                    System.out.println("Enter Sender: ");
                    x = sc.nextInt();
                    ring.pingCoordinator(x);
                    break;
                }
            }
        }
        
    }
}