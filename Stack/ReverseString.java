import java.util.*;

public class ReverseString {

    public static String reverse(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;

        while (idx < str.length()) {
            char ch = str.charAt(idx);
            s.push(ch);
            idx++;
        }
        
        StringBuilder soln = new StringBuilder();
        while (!s.isEmpty()) {
            soln.append(s.pop());
        }
        
        str = soln.toString();

        return str;
    }

    public static void main(String[] args) {
        String str = "abcd";
        str = reverse(str);
        System.out.println(str);
    }
}
