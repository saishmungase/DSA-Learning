import java.util.ArrayList;
import java.util.Collections;

public class BasicArrayList{

    public static void main(String args[]){

        // Initialization 
        ArrayList <Integer> list = new ArrayList<>();

        // Adding
        list.add(5); // O(n)
        list.add(1);
        list.add(9);
        System.out.println(list);

        // Insertion
        list.add(1, 6);
        System.out.println(list);

        // Getting
        System.out.println(list.get(3));

        // Deleting
        list.remove(1);
        System.out.println(list);

        // Updating
        list.set(1, 2);
        System.out.println(list);

        // Checking for presence
        System.out.println(list.contains(9));

        // Size
        System.out.println(list.size());

        //Sorting 
        //ascending
        Collections.sort(list);
        System.out.println(list);

        // decending
        // Comparator - Funtion Logic => .reverseOrder();
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

    }

}