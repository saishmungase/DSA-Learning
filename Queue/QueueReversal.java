import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

    static void reverseQueue(Queue<Integer> q){
        Stack<Integer> temp = new Stack<>();
        while (!q.isEmpty()) {
            temp.push(q.remove());
        }
        while (!temp.isEmpty()) {
            q.add(temp.pop());
        }
    }
    public static void main(String[] args) {
        Queue <Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        reverseQueue(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
