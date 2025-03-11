import java.util.PriorityQueue;

public class ConnectNRopes {
    
    public static int ropeCost(int arr[]){
        int totalCost = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i  = 0; i<arr.length; i++){
            q.add(arr[i]);
        }
        while(q.size() > 1){
            int first = q.remove();
            int second = q.remove();
            int cost = first + second;
            totalCost += cost;
            q.add(cost);
        }
        return totalCost;
    }
    
    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 6};
        System.out.println(ropeCost(arr));
    }
}
