import mpi.*;

public class ScatterGather
{
    public static void main(String args[])
    {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int[] array = {10,20,30,40,50,100,120,130,140,150,200,200};

        int n = array.length;
        int elementsPerProcessor = n/size;

        int[] localElements = new int[elementsPerProcessor];

        MPI.COMM_WORLD.Scatter(array,0,elementsPerProcessor,MPI.INT,
        localElements,0,elementsPerProcessor,MPI.INT,0);

        int localsum = 0;
        for(int i=0; i<elementsPerProcessor; i++)
        {
            localsum += localElements[i];
        }

        System.out.println("Processor : "+rank+" | Local Sum : "+localsum);

        int[] globalsums = new int[size];
    
        MPI.COMM_WORLD.Gather(new int[]{localsum},0,1,MPI.INT,
        globalsums,0,1,MPI.INT,0);

        if(rank == 0)
        {
            int finalsum = 0;
            for(int sum : globalsums)
            {
                finalsum+= sum;
            }
            System.out.println("Final Sum is : "+finalsum);
        }

        MPI.Finalize();
    

    }
}