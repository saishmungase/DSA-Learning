// 1, 8, 6, 2, 5, 4, 8, 3, 7
import java.util.ArrayList;

public class ContainerWater{

    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        // Soln
        int i = 0; 
        int j = list.size()-1;
        int max = Integer.MIN_VALUE;

        while(i<j){
            if(i > j){
                j--;
            }
            else{
                i++;
            }
            max = Math.max(max, ((j-i)*(Math.min(list.get(i), list.get(j)))));
        }

        System.out.println(max);

    }

}