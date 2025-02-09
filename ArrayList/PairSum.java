import java.util.ArrayList;

public class PairSum{

    public static ArrayList<Integer> pairSum(ArrayList<Integer> list, int target){
        int i = 0; 
        int j = list.size()-1;
        ArrayList<Integer> soln = new ArrayList<>();
        while(i < j){
            int sum = list.get(i)+list.get(j);

            if(sum == target){
                soln.add(list.get(i));
                soln.add(list.get(j));
                break;
            }
            else if(sum > target){
                j--;
            }
            else{
                i++;
            }
        }
        return soln;
    }

    public static void main(String args[]){

        ArrayList <Integer> list = new ArrayList<>();
        for(int i = 1; i<=5; i++){
            list.add(i);
        }
        ArrayList <Integer> soln = new ArrayList<>();
        soln = pairSum(list, 5);
        System.out.print(soln);
    }
}