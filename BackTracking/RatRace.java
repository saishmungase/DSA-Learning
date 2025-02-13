
class RatRace {

    public static boolean ratRace(int arr[][], int row, int col, String str){
        if(row == arr.length -1 && col == arr.length - 1 && arr[row][col] == 1){
            System.out.println(str);
            return true;
        }

        else if(row < 0 || row >= arr.length || col < 0 || col >= arr.length || arr[row][col]==0){
            return false;
        }

        arr[row][col] = 0;

        ratRace(arr, row+1, col, str + "Down-");
        ratRace(arr, row, col+1, str + "Right-");
        ratRace(arr, row-1, col, str + "Up-");
        ratRace(arr, row, col-1, str + "Left-");

        arr[row][col] = 1;

        return false;

    }

    public static void main (String args[]){
        int maze[][] = { { 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 0, 1, 0, 0 },
                        { 1, 1, 1, 1 } };
        ratRace(maze, 0, 0, "");

        for(int i = 0; i<maze.length; i++){
            for(int j = 0; j<maze.length; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}