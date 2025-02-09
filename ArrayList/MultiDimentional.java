import java.util.ArrayList;
import java.util.Collections;

public class MultiDimentional{

    public static void main(String args[]){

        ArrayList<ArrayList<Integer>> main = new ArrayList<>();

        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        ArrayList<Integer> three = new ArrayList<>();

        for(int i = 1; i<=5; i++){
            one.add(i);
            two.add(i*2);
            three.add(i*3);
        }

        main.add(one);
        main.add(two);
        main.add(three);

        System.out.println(main);

        // Accessing The Element
        for(int i = 0; i<main.size(); i++){
            ArrayList <Integer> temp = main.get(i);
            for(int j = 0; j<temp.size(); j++){
                System.out.print(temp.get(j) + " ");
            }
            System.out.println();
        }

    }

}