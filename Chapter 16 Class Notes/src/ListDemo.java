/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList students = new LinkedList();
        students.addFirst("Robbie");
        students.addFirst("Henry");
        students.addFirst("Henry A");
        students.addFirst("Henry Al");
        System.out.println(students);
    }
}
