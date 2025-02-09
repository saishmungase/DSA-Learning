import java.util.*;

class Questions{

    // Lonely Number
    public static ArrayList <Integer> lonelyBoi(ArrayList <Integer> list){
        ArrayList <Integer> soln = new ArrayList <>();
        Collections.sort(list);
        soln.add(list.get(0));
        for(int i = 1; i<list.size()-1; i++){

            int prev = list.get(i-1);
            int val = list.get(i);
            int next = list.get(i+1);

            if(){
                continue;
            }
            soln.add(val);
        }
        soln.add(list.get(list.size()-1));
        return soln;
    }

    public static void main(String args[]){
        ArrayList <Integer> list = new ArrayList <>();
        // [1,3,5,3]
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(3);
        System.out.println(lonelyBoi(list));
    }
}