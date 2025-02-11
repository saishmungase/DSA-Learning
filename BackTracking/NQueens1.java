public class NQueens1 {

    public static void nQueens(char arr[][], int r){
        //Bas Case 
        if(r == arr.length){
            printBoard(arr);
            return;
        }

        //Kaam
        for(int j = 0; j<arr.length; j++){
            if(isSafe(arr, j, r)){
                arr[r][j] = 'Q';
                nQueens(arr, r+1);
                arr[r][j] = '_';
            }
        }
    }

    public static void printBoard(char arr[][]){
        System.out.println("------------ Chess Board ------------");
        for(int i =0; i<arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Boolean isSafe(char arr[][], int c, int r){
        for(int i = 0; i<r; i++){
            if(arr[i][c] == 'Q'){
                return false;
            }
        }

        int i = r; 
        int j = c;

        while (i>=0 && j>=0) {
            if(arr[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }
        
        i = r; 
        j = c;
        
        while (i >=0 && j <arr.length) {
            if(arr[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }


        return true;
    }
    public static void main(String[] args) {
        char arr[][] = new char[4][4];
        for(int i =0; i<arr.length; i++){
            for(int j = 0; j<arr.length; j++){
                arr[i][j] = '_';
            }
        }
        nQueens(arr, 0);
    }
}
