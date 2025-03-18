import java.util.Queue;
import java.util.LinkedList;

// Problem Statement: Generating Permutations
// Description: Given a set of n distinct characters, generate all possible permutations of these characters.

// Input: A string s consisting of n distinct characters.

// Output: A list of all possible permutations of the characters in the string s.

// Example:

// Input: "ABC"
// Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
// Constraints:

// The length of the input string s (denoted as n) is between 1 and 10.

// All characters in the string are distinct.



public class GeneratingPermutation {
    public static void printPermutations(String str){
        Queue<String> q = new LinkedList<>();
        q.add("");
        while(!q.isEmpty()){
            String str1 = q.remove();
            if(str.length() == str1.length()){
                System.out.println(str1);
            }
            else{
                for(int i = 0; i<str.length(); i++){
                    char c = str.charAt(i);
                    if(!str1.contains(String.valueOf(c))){
                        q.add(str1 + c);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        printPermutations("ABC");
    }

}
