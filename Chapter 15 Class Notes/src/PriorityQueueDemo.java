import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // Create a to-do list
        // The WorkOrder class has a priority and description
        Queue<WorkOrder> toDo = new PriorityQueue<>();
        toDo.add(new WorkOrder(5, "water plants"));
        toDo.add(new WorkOrder(1, "finish sign"));
        toDo.add(new WorkOrder(2, "come up with topic for essay"));
        toDo.add(new WorkOrder(4, "Do Software HW"));
        toDo.add(new WorkOrder(5, "Go to school"));

        // Objects are NOT stored in priority order
        System.out.println(toDo);

        // Objects ARE removed in priority order
        while(toDo.size() > 0){
            System.out.println(toDo.remove());
        }
    }
}
