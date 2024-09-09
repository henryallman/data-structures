import java.util.*;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        Set<Integer> nums = new HashSet<>();
        for (int i = 2; i<=n; i++){
            nums.add(i);
        }
        for (int i = 2; i<=n; i++){
            for(int j = 2; i*j<=n ; j++){
                if(nums.contains(i*j)){
                    nums.remove(i*j);
                }
                
            }
            
        }
        nums.add(2);
        System.out.print(nums);
    
    }
}

