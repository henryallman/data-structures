import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    { 
        LinkedList<String> temp = new LinkedList<String>();
        ListIterator<String> it = strings.listIterator();
        ListIterator<String> it2 = temp.listIterator();
        for (int i=0;it.hasNext(); i++){
            it2.add(it.next());
            it2.previous();
        }
        it = strings.listIterator();
        for (int i = 0; it2.hasNext(); i++){
            it.add(it2.next());
            it.next();
            it.remove();
        }
        
        
    }
}