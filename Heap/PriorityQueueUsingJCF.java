import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueUsingJCF {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(4); // log(n) n= no. of elem in queue;
        pq.add(2);
        pq.add(3);
        pq.add(10);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); // O(1)
            pq.remove(); // log(n)
        }
    }
}
