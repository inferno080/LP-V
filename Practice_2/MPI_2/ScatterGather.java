import mpi.*;

public class ScatterGather
{
    public static void main(String args[])
    {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int[] array = {10,20,10,20,20,30,50,90};
        int n = array.length;
        int elements_per_node = n/size;

        int[] localelements = new int[elements_per_node];

        MPI.COMM_WORLD.Scatter(array,0,elements_per_node,MPI.INT, localelements, 0,elements_per_node,MPI.INT,0);

        int local_sum = 0;
        for(int i=0; i<elements_per_node; i++)
        {
            local_sum += localelements[i];
        }
        System.out.println("Processor :"+ rank+ "     Sum : "+local_sum);

        int[] globalsums = new int[size];
        MPI.COMM_WORLD.Gather(new int[]{local_sum}, 0,1, MPI.INT,globalsums,0,1,MPI.INT,0);

        if(rank == 0)
        {
            int finalsum = 0;
            for(int x : globalsums)
            {
                finalsum += x;
            }
            System.out.println("Final Sum is :"+ finalsum);
        }
        MPI.Finalize();


    }
}