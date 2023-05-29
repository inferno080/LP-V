import mpi.*;

public class ScatterGather
{
    public static void main(String args[])
    {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int n = array.length;
        int elementsPerProcessor = n/size;
        
        int[] localElements = new int[elementsPerProcessor];

        MPI.COMM_WORLD.Scatter(array,0,elementsPerProcessor,MPI.INT,
        localElements,0,elementsPerProcessor,MPI.INT,0);

        int local_sum = 0;
        for(int i=0; i<elementsPerProcessor; i++)
        {
            local_sum += localElements[i];
        }
        System.out.println("Processor : "+rank+" | Local_Sum : "+local_sum);

        int[] globalelements = new int[size];

        MPI.COMM_WORLD.Gather(new int[]{local_sum},0,1,MPI.INT,
        globalelements,0,1,MPI.INT,0);

        if(rank == 0)
        {
            int globalsum = 0;
            for(int sum : globalelements)
            {
                globalsum += sum;
            }
            System.out.println("Final Sum : "+globalsum);
        }
        MPI.Finalize();


    }   
}