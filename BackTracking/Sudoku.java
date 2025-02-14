class Sudoku {
    
    public static boolean isSafe(int arr[][], int row, int col, int digit){
        
        //Horizontal / Vertical Check
        for(int i = 0; i<9; i++){
            if(arr[row][i] == digit){
                return false;
            }
            if(arr[i][col] == digit){
                return false;
            }
        }
        
        //In Block Check
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i = sr; i<sr+3; i++){
            for(int j = sc; j<sc+3; j++ ){
                if(arr[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean sudokuSolver(int arr[][], int row, int col){
        
        //Base
        if(row == 9){
            return true;
        }
        
        //Kaam
        
        int newRow = row, newCol = col+1;
        if(newCol == 9){
            newRow = row + 1;
            newCol = 0;
        }
        
        if(arr[row][col] != 0){
            return sudokuSolver(arr, newRow, newCol);
        }
        
        for(int digit = 1; digit <=9; digit++){
            if(isSafe(arr, row, col, digit)){
                arr[row][col] = digit;
                if(sudokuSolver(arr, newRow, newCol)){
                    return true;
                }
                arr[row][col] = 0;
            }
            
        }
        return false;
    }
    
    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] sudokuBoard = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        
        sudokuSolver(sudokuBoard, 0, 0);
        printBoard(sudokuBoard);
        
    }
}