import mpi.*;

public class ScatterGather
{
    public static void main(String args[])
    {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int[] inputarray = {10,20,30,40,50,60,70,80};
        int n = inputarray.length;
        int elements_per_processor = n/size;

        int[] localelements = new int[elements_per_processor];

        MPI.COMM_WORLD.Scatter(
            inputarray,0,elements_per_processor,MPI.INT,
            localelements,0,elements_per_processor,MPI.INT,0
            );
        
        int localsum = 0;
        for(int i=0; i<elements_per_processor; i++)
        {
            localsum += localelements[i];
        }

        System.out.println("Process : "+rank+"   |   Sum : "+localsum);

        int[] globalSums = new int[size];
        MPI.COMM_WORLD.Gather(
            new int[]{localsum},0,1,MPI.INT,
            globalSums,0,1,MPI.INT,0
        );

        if(rank == 0)
        {
            int finalSum = 0;
            for(int x : globalSums)
            {
                finalSum += x;
            }
            System.out.println("Global total : "+ finalSum);
        }
        MPI.Finalize();
    }
}