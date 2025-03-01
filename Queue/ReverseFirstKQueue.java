import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Stack;

public class ReverseFirstKQueue {
    public static void reverseFirstKFromQ(Queue <Integer> q, int n){
        int qSize = q.size();
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<n; i++){
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        for(int i = 0; i<qSize - n; i++){
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i<=10; i++){
            q.add(i);
        }
        reverseFirstKFromQ(q, 5);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }

}
