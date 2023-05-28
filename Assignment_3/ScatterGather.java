import mpi.*;

public class ScatterGather {
    public static void main(String[] args) throws MPIException {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        // Define the array to be summed
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Replace with your own array

        // Calculate the number of elements to be processed by each processor
        int n = array.length;
        int elementsPerProcessor = n / size;

        // Allocate memory to store local elements
        int[] localElements = new int[elementsPerProcessor];

        // Scatter the array elements to all processors
        MPI.COMM_WORLD.Scatter(array, 0, elementsPerProcessor, MPI.INT,
                localElements, 0, elementsPerProcessor, MPI.INT, 0);

        // Calculate the local sum
        int localSum = 0;
        for (int i = 0; i < elementsPerProcessor; i++) {
            localSum += localElements[i];
        }

        // Display the intermediate sums calculated at different processors
        System.out.println("Processor " + rank + ": Local sum = " + localSum);

        // Allocate memory for the global sums at all processes
        int[] globalSums = new int[size];

        // Gather all local sums at all processes
        MPI.COMM_WORLD.Gather(new int[]{localSum}, 0, 1, MPI.INT,
                globalSums, 0, 1, MPI.INT, 0);

        // Display the final sum at processor 0
        if (rank == 0) {
            int finalSum = 0;
            for (int sum : globalSums) {
                finalSum += sum;
            }
            System.out.println("Final sum = " + finalSum);
        }

        MPI.Finalize();
    }
}
