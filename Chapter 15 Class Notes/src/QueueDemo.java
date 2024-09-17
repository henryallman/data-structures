import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        // Create a print queue of strings (using a linked list)
        Queue<String> jobs = new LinkedList();
        
        // Add some print jobs
        jobs.add("Robbie: Quantitative Lit Paper");
        jobs.add("Henry: Cool Guy Papers");

        System.out.println("Printing: " + jobs.remove());

        // Add some more things to the queue
        jobs.add("Andrew: Sigma Documentation");
        jobs.add("Logan: Untitled Document");
        jobs.add("Sigma: Rizz");

        System.out.println("Printing: " + jobs.remove());

        jobs.add("Tom: Who knows");
        
        // Print the rest of the jobs in the queue
        while (jobs.size() > 0){
            System.out.println("Printing: " + jobs.remove());
        }
    }
}
