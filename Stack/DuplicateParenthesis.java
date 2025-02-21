import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean duplicateBracket(String s){
        Stack<Character> ch = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                int quickGet = 0;
                while (ch.peek() != '(') {
                    ch.pop();
                    quickGet++;
                }
                if(quickGet < 1){
                    return true;
                }
                ch.pop();
            }else{
                ch.push(c);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(duplicateBracket("((a+(b))+(c+d))"));
    }
}
