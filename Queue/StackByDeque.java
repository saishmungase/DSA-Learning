import java.util.ArrayDeque;
import java.util.Deque;

public class StackByDeque {

    public static class Stack {
        Deque<Integer> dq = new ArrayDeque<>();

        boolean isEmpty() {
            return dq.isEmpty();
        }

        void push(int data) {
            dq.addFirst(data);  
        }

        int pop() {
            return dq.removeFirst();
        }

        int peek() {
            return dq.getFirst();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(4);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.println(s.pop()); 
        }
    }
}
