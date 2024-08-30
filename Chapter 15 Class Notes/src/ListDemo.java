import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        // The addLast method can be used to populate a list
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamora");

        // The list is currently: TNPG
        /*
         * The listIterator method cretes a new list iterator
         * that is positioned at the head of the list.
         * The "|" is used to represent the iterator position
         */
        ListIterator<String> iterator = staff.listIterator(); //|TNPG

        /*The next method advances the iterator over the next element in the list. */
        iterator.next(); // T|NPG
        
        /*The net method also returns the element that the iterator passes over. */
        String avenger = iterator.next(); //TN|PG
        System.out.println(avenger); //Should print Natasha

        /*The add method inserts an element at the iterator position.
         * The iterator is then positioned AFTER the element that was added.
         */
        iterator.add("Steve");
        iterator.add("Clint");

        System.out.println(staff);

        /*The remove method removes the element returned by the last call to next or previous.
         * The remove method can ONLY be called after calling next or previous.
         * The remove method CANNOT be called after calling add.
         */
        iterator.next(); // TNSCP|G
        iterator.remove();
        System.out.println(staff);

        /*The set method updates the element returned by the last call to next or previous */
        iterator.previous(); //TNS|CG
        iterator.set("T'Challa"); // TNS|TG

        /*The hasNext method is used to determine if there is a next node after the iterator.
         * the hasNext method is often used in the condition of a while loop
         */
        iterator = staff.listIterator(); // |TNSTG
        while (iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Natasha")){  //TN|STG
                iterator.remove();
                System.out.print("KILL JOHN LENNON\n");
            }
        } // TSTG|

        /*Enhanced for loops work with linked lists */
        for (String n : staff){
            System.err.print(n + " ");
        }
        System.out.println();

        /*
         * ConcurrentModificationException
         * 
         * CANNOT modify a linked list while using an iterator
         * UNLESS you use the iterator to do the modification
         */
        iterator = staff.listIterator(); // |TSTG
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Tony")) {
                // staff.remove("Tony");     ConcurrentModificationException bc not using iterator to remove
            }
        }

        /*
         * The enhanced for loop AUTOMTICALLY creates an interator.
         */

         for (String n : staff){
            if (n.equals("Tony")) {
                // staff.add("Bruce");  cant add or remove because dont have iterator access
            }
         }

         System.out.println("staff");

    }
}
