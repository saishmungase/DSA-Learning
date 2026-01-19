import java.util.*;


class Row implements Comparable<Row>{
    int row;
    int rowSum;

    Row(int row, int rowSum){
        this.row = row;
        this.rowSum = rowSum;
    }

    @Override
    public int compareTo(Row r2){
        if(this.rowSum == r2.rowSum){
            return this.row - r2.row;
        }
        return this.rowSum - r2.rowSum;
    }
}

public class WeakestSoldier {
    public static void main(String[] args) {
        int arr[][] = {{1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0}};
        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i = 0; i<arr.length; i++){
            int sum = 0;
            for(int j = 0; j<arr[0].length; j++){
                sum += arr[i][j];
            }
            pq.add(new Row(i, sum));
        }

        for(int i = 0; i<k; i++){
            System.out.println("R"+pq.remove().row);
        }
    }
}