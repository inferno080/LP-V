import java.util.Scanner;

public class Bully 
{
    int n, inactive_count;
    int coordinator;
    boolean loss = false;
    boolean[] process_state;

    public Bully(int n)
    {
        this.n = n;
        this.inactive_count = 0;
        this.process_state = new boolean[n];
        for(int i=0; i<n; i++)
        {
            this.process_state[i] = true;
        }
    }

    public void up(int x)
    {
        if(x < 0 || x >= n)
        {
            System.out.println("Process doesn't exist\n");
            return;
        }
        if(process_state[x])
        {
            System.out.println("Process already active\n");
        }
        else
        {
            process_state[x] = !process_state[x];
            System.out.println("Process "+x+" activated\n");
            System.out.println("Process "+x+" held election\n");
            for(int i=x+1; i<n; i++)
            {
                System.out.println("Election message sent from proceess "+ x+ " to process "+(i)+"\n");
            }
            for(int i=n-1; i>x; i--)
            {
                if(process_state[i])
                {
                    System.out.println("Alive message sent from "+i +" to "+x+"\n");
                    coordinator = i;
                    loss = true;
                    System.out.println(x+" Lost election "+" to "+i+"\n");
                    break;
                }
            }
            if(!loss)
            {
                System.out.println ("New coordinator : "+ x);
                this.coordinator = x;
            }
        }
    }

    public  void down(int x)
    {
        if(x < 0 || x >= n)
        {
            System.out.println("Process doesn't exist\n");
            return;
        }
        if(!process_state[x])
        {
            System.out.println("process "+x+" is already dowm.\n");
        }
        else
        {
            process_state[x] = false;
        }
    }

    public void message(int x)
    {
        if(x < 0 || x >= n)
        {
            System.out.println("Process doesn't exist\n");
            return;
        }
        if(!process_state[coordinator])
        {
            System.out.println("Coordinator didn't respond \n");
            System.out.println("Process "+x+" held election \n");
            for(int i=x+1; i<n; i++)
            {
                System.out.println("Election message sent from proceess "+ x+ " to process "+(i)+"\n");
            }
            for(int i=n-1; i>x; i--)
            {
                if(process_state[i])
                {
                    System.out.println("Alive message sent from "+i +" to "+x+"\n");
                    coordinator = i;
                    loss = true;
                    System.out.println(i +" Lost election "+" to "+x+"\n");
                    break;
                }
            }
            if(!loss)
            {
                System.out.println ("New coordinator : "+ x);
                this.coordinator = x;
            }
        }
        else
        {
            System.out.println("Message Sent Successfully");
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of processes : \n");
        int n = sc.nextInt();
        int c = 0, i;
        Bully x = new Bully(n);
        while(c!=4)
        {
            System.out.println("=======================");
            System.out.println("1. Deactivate a process");
            System.out.println("2. Activate a process");
            System.out.println("3. Send Message");
            System.out.println("=======================");
            System.out.println("Enter Choice : ");
            c = sc.nextInt();
            switch(c)
            {
                case 1:
                {
                    System.out.println("Enter Process ID : ");
                    i = sc.nextInt();
                    x.down(i);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter Process ID : ");
                    i = sc.nextInt();
                    x.up(i);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter Process ID : ");
                    i = sc.nextInt();
                    x.message(i);
                    break;
                }
            }
        }
    }
}
