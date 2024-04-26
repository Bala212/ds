import mpi.MPI;
import mpi.*;

public class MPI {

    public static void main(String[] args) throws Exception{

        // 1. initializes MPI
        MPI.Init(args);

        // getting the rank (identifier) of the current process 
        int rank = MPI.COMM_WORLD.Rank();

        // the total number of processes.
        int processes = MPI.COMM_WORLD.Size();

        // 2. It defines a unit size (number of elements each process handles)
        int processSize = 5;

        int root = 0;

        // 3. creates send and receive buffers accordingly.
        int send_buffer[] = null;

        //  1 process is expected to handle 4 elements
        send_buffer = new int [processSize * processes];

        // process che elements
        int recieve_buffer[] = new int [processSize];

        // stores final sum of each process
        int new_recieve_buffer[] = new int [processes];

        //  Set data for distribution
        if(rank == root) {
            int total_elements = processSize * processes;
            System.out.println("Enter " + total_elements + " elements");
            for(int i = 0; i < total_elements; i++) {
                System.out.println("Element " + i + "\t = " + i);
                // Array index vr to index store kela. For further processing
                send_buffer[i] = i+1;
            }
        }

        //  Scatter data to processes
        MPI.COMM_WORLD.Scatter(
            send_buffer, // kon send karnar?
            0, // 
            processSize, // Ek process la kiti send karayche?
            MPI.INT, // MPI_dataType.DataTypeWe are passing
            recieve_buffer, // Kon recieve karnar
            0, // 
            processSize, // Ek process kiti ghenar
            MPI.INT, 
            root // root kon ahe?
        );

        //  Calculate sum at non root processes
        //  Store result in first index of array
        for(int i = 1; i < processSize; i++) {
            // Current process chya reciever buffer madhe 0th index la sum store karan tya process chi
            recieve_buffer[0] += recieve_buffer[i];
        }
        System.out.println(
            "Intermediate sum at process " + rank + " is " + recieve_buffer[0]
        );

        //  Gather data from processes
        MPI.COMM_WORLD.Gather(
            recieve_buffer,
            0,
            1, // apan ek ch data send karat ahot (0th index la jee sum present ahe ti !!)
            MPI.INT,
            new_recieve_buffer, // STORING SUM OF EACH PROCESS IN this buffer
            0,
            1, // ek ch element ghenar ahot. As a sum of each process
            MPI.INT,
            root
        );

        //  Aggregate output from all non root processes
        if(rank == root) {
            int total_sum = 0;
            for(int i = 0; i < processes; i++) {
                // new_recieve_buffer stores sum of each process in it's respective process
                total_sum += new_recieve_buffer[i];
            }
            System.out.println("Final sum : " + total_sum);
        }
        MPI.Finalize();

    }

}

