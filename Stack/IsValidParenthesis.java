import java.util.Stack;

public class IsValidParenthesis {
    public static boolean isValidBrackets(String str){
        Stack<Character> ch = new Stack<>();
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '(' || c =='[' || c == '{'){
                ch.push(c);
            }
            else{
                if(ch.isEmpty()){
                    return false;
                }
                if((ch.peek() == '(' && c == ')') 
                || (ch.peek() == '[' && c == ']')
                || (ch.peek() == '{' && c == '}'))
                {
                    ch.pop();
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValidBrackets("(({[]})])"));
    }
}
