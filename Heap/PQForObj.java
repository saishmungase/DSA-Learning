import java.util.Comparator;
import java.util.PriorityQueue;

class Student implements Comparable<Student>{
    String name;
    int rank;

    Student(String name, int rank){
        this.name = name;
        this.rank =rank;
    }

    @Override
    public int compareTo(Student s2){
        return this.name.charAt(0)-s2.name.charAt(0);
    }

}

public class PQForObj {
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Shreeman", 9)); 
        pq.add(new Student("Karan", 3));
        pq.add(new Student("Chetan", 5));
        pq.add(new Student("Daku", 8));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " " + pq.peek().rank);
            pq.remove();
        }
        
    }
}
