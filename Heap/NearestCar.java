import java.util.PriorityQueue;

public class NearestCar {

    static class Point implements Comparable<Point>{
        int idx;
        int distSqr;

        public Point(int idx, int distSqr){
            this.idx = idx;
            this.distSqr = distSqr;
        }

        @Override
        public int compareTo(Point p){
            return this.distSqr - p.distSqr;
        }
    }
    public static void main(String[] args) {
        int arr[][] = { { 3, 3}, { 5, -1}, { -2, 4} };
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0; i<arr.length; i++){
            int distSqr = arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1];
            pq.add(new Point(i, distSqr));
        }

        while(k > 0){
            System.out.println("C" + pq.remove().idx);
            k--;
        }
    }
}
