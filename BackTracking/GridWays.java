public class GridWays {

    public static int gridWay(int currD, int currL, int finD, int finL){
        if(currD == finD-1 && currL == finL-1){
            return 1;
        }
        else if(currD == finD || currL == finL){
            return 0;
        }
        int way1 = gridWay(currD+1, currL, finD, finL);
        int way2 = gridWay(currD, currL+1, finD, finL);

        return way1 + way2;
    }
    public static void main(String[] args) {
        System.out.println(gridWay(0, 0, 3, 3));
    }
}
