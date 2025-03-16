import java.util.LinkedList;
import java.util.Queue;

// Problem Statement: Generating Combinations
// Description: Given a set of n distinct characters and an integer k, generate all possible combinations of k characters from the set.

// Input: A string s consisting of n distinct characters and an integer k (where 1 <= k <= n).

// Output: A list of all possible combinations of k characters from the string s.

// Example:

// plaintext
// Input: s = "ABC", k = 2
// Output: ["AB", "AC", "BC"]
// Constraints:

// The length of the input string s (denoted as n) is between 1 and 10.

// All characters in the string are distinct.

// The value of k is between 1 and n.



public class GeneratingCombination {
     public static void generateCombination(String str, int n){
        Queue<String> q = new LinkedList<>();
        q.add("");
        while (!q.isEmpty()) {
            String current = q.remove();

            if (current.length() == n) {
                System.out.println(current);
            } else {
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    if (!current.contains(String.valueOf(ch))) {
                        q.add(current + ch);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        generateCombination("ABC", 2);
    }

}
