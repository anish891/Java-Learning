import javax.sound.sampled.AudioFileFormat.Type;

public class BackTracking {

    public static void changeArray(int arr[], int index, int value) {
        // base case
        if(index == arr.length){
            printArray(arr);
            return;
        }
        // recursion - kaam
        arr[index] = value;
        changeArray(arr, index+1, value+1);   // function call
        arr[index] = arr[index] - 2;     // backtracking step
    }

    public static void printArray(int arr[]) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void findSubsets(String str, String ans, int i) {   // i is the index of character
        // base case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            } else{
                System.out.println(ans);
            }
            return;
        }
        // recursion
        // Yes choice
        findSubsets(str, ans+str.charAt(i), i+1);
        // No choice
        findSubsets(str, ans, i+1);

    }

    public static void findPermutation(String str, String ans) {
        // base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        } 
        // recursion
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            // "abcde" = "ab" + "de"
            String Newstr = str.substring(0, i) + str.substring(i+1);
            findPermutation(Newstr, ans+curr);
        }
    }

    public static boolean isSafeForNQueens(char board[][], int row, int col) {     // function for N-Queens Problem
        // vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // diagonal left up
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // diagonal right up
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static boolean nQueens(char board[][], int row) {
        // base case
        if(row == board.length){
            // printBoard(board);
            count++;
            return true;
        }
        // column loop
        for(int j=0;j<board.length;j++){
            if(isSafeForNQueens(board, row, j)){
                board[row][j] = 'Q';
                // nQueens(board, row+1);    // function call
                if(nQueens(board, row+1)){
                    return true;
                }
                board[row][j] = 'x';      // backtracking step
            }
        }
        return false;
    }


    public static void printBoard(char board[][]) {         // function for N-Queens Problem
        System.out.println("------ chess board ------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int gridWays(int i, int j, int n, int m) {    //(i, j) is the current cell and nxm is the size of the grid
        // base case
        if(i == n-1 && j == m-1){    // condition for last cell
            return 1;
        } else if(i == n || j == n){  // boundary cross condition
            return 0;
        }
        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;
    }

    static int count =0;

    public static boolean isSafeForSudoku(int sudoku[][], int row, int col, int digit) {
        // column 
        for(int i=0;i<=8;i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }

        // row
        for(int j=0;j<=8;j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }

        // grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        // 3x3 grid
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3;j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // base case
        if(row == 9){
            return true;
        } 
        // recursion
        int nextRow= row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit = 1; digit <= 9; digit++){
            if(isSafeForSudoku(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                sudokuSolver(sudoku, nextRow, nextCol);
                if(sudokuSolver(sudoku, nextRow, nextCol)){  // solution exists
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Backtarcking on Arrays
        // int arr[] = new int[5];
        // changeArray(arr, 0, 1);
        // printArray(arr);

        // find subsets of a string
        // String str = "abc";
        // findSubsets(str, "", 0);

        // find Permutations of a String
        // String str = "abc";
        // findPermutation(str, "");

        // N-Queens Problem
        // int n = 4;
        // char board [][] = new char [n][n];
        // // initialze the board
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         board[i][j] = 'x';
        //     }
        // }
        // // nQueens(board, 0);
        // if(nQueens(board, 0)){
        //     System.out.println("Solution is possible");
        //     printBoard(board);
        // } else{
        //     System.out.println("Solution is not possible");
        // }
        // System.out.println("total ways to solve N-Queens is eaual to "+count);


        // Grid Ways
        // int n=4, m=4;
        // System.out.println(gridWays(0, 0, n, m));


        // Sudoku Solver
        int sudoku[][] = {  {0, 0, 8, 0, 0, 0, 0, 0, 0},   
          {4, 9, 0, 1, 5, 7, 0, 0, 2},   
          {0, 0, 3, 0, 0, 4, 1, 9, 0},   
          {1, 8, 5, 0, 6, 0, 0, 2, 0},   
          {0, 0, 0, 0, 2, 0, 0, 6, 0},   
          {9, 6, 0, 4, 0, 5, 3, 0, 0},   
          {0, 3, 0, 0, 7, 2, 0, 0, 4},   
          {0, 4, 9, 0, 3, 0, 0, 5, 7},   
          {8, 2, 7, 0, 0, 9, 0, 1, 3}   
       }; 
       if(sudokuSolver(sudoku, 0, 0)){
        System.out.println("solution exists");
        printSudoku(sudoku);
       } else {
        System.out.println("solution does not exist");
       }
    
    }
}
