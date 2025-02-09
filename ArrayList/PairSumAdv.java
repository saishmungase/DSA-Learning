import java.util.*;

public class PairSumAdv{

    public static void pairSumAdv(ArrayList <Integer> list, int target, int lp, int rp){
       
        if(lp == rp){
            System.out.print("Not Found !");
            return;
        }
        int sum = list.get(lp) + list.get(rp);

        if(sum == target){
            System.out.print(list.get(lp) + ", " + list.get(rp));
            return;
        }

        else if(sum < target){
            lp = (lp + 1) % list.size();
        }

        else{
            rp = (list.size() + rp - 1) % list.size();
        }

        pairSumAdv(list, target, lp, rp);

    }

    public static void main(String args[]){

        ArrayList <Integer> list = new ArrayList<>();
        list.add(14);
        list.add(15);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int target = 7;
        pairSumAdv(list, target, 2, 1);
    }

}