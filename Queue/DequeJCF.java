import java.util.Deque;
import java.util.LinkedList;

public class DequeJCF {

    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(2);
        dq.addFirst(1);
        dq.addLast(3);
        System.out.println(dq.getFirst());
        System.out.println(dq.getLast());
    }
}
