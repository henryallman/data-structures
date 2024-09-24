import java.io.*;
import java.util.*;
/**
 * Read all words from a file and add them to a map
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter.
 * Then print out the word sets in alphabetical order.
 * Use the Java 8 merge() feature.
*/
public class FirstLetterMap
{
    public static void main(String[] args)
    {
        String filename = "H:\\Software\\data-structures\\Chapter 15 Activities\\FirstLetterMap\\FirstLetterMap1\\src\\test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map<Character, HashSet<String>> words = new HashMap<Character, HashSet<String>>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Character acter = word.charAt(0);

                // Update the map here
                // Use the Java 8 merge method
                words.merge(acter, new HashSet<>(Collections.singleton(word)), (oldValue, newValue) -> {oldValue.addAll(newValue);
                return oldValue;});

            }

            // Print the map here in this form
            // a: [a, able, aardvark]
            for(Character i : words.keySet())
            {
                System.out.println(i + ": " + words.get(i));
            }
            
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}