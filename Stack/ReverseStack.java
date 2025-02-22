import java.util.Stack;

public class ReverseStack {

    public static void insertAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int popedData = s.pop();
        insertAtBottom(s, data);
        s.push(popedData);
    }

    public static void reverse(Stack <Integer> s){
        if(s.isEmpty()){
            return;
        }
        int data = s.pop();
        reverse(s);
        insertAtBottom(s, data);
    }

    public static void main(String[] args) {
        Stack <Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        reverse(s);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
