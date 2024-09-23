import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
 */
public class HTMLChecker {
    public static void main(String[] args) {
        String filename = "/Users/Henry/Desktop/data-structures/Chapter 15 Activities/HTMLChecker/src/TagSample1.html"; 

        try (Scanner in = new Scanner(new File(filename))) {
            Stack<String> tagStack = new Stack<>();

            while (in.hasNext()) {
                String tag = in.next(); 

                if (tag.startsWith("<") && tag.startsWith("</")==false && tag.endsWith(">")) {
                    tagStack.push(tag); 
                } 

                else if (tag.startsWith("</") && tag.endsWith(">")) {
                    if (tagStack.isEmpty()) {
                        System.out.println("Error: Closing tag " + tag + " found, but no matching opening tag.");
                        return;
                    }
                    String lastTag = tagStack.pop();
                    String name = lastTag.substring(1, lastTag.length() - 1);
                    String name2 = tag.substring(2, tag.length() - 1);
                    if (name.equals(name2)==false) {
                        System.out.println("Error: Tag " + lastTag + " does not match closing tag " + tag);
                        return;
                    }
                }
            }

            if (tagStack.isEmpty()==false) {
                System.out.println("Error: Unmatched opening tag(s) remain: " + tagStack);
            } else {
                System.out.println("All tags are properly nested.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + filename);
        }
    }
}
