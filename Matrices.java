import java.security.cert.X509CRL;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
import javax.swing.text.AbstractDocument.LeafElement;

public class Matrices {

    public static boolean search(int matrix[][], int key) {    // for searching 
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == key){
                    System.out.println("element found at (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static void largestAndSmallest(int matrix[][]) {
        int smallest = Integer.MAX_VALUE;
            int largest = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(largest < matrix[i][j]){
                    largest = matrix[i][j];
                }
                if(smallest > matrix[i][j]){
                    smallest = matrix[i][j];
                }
            }
        }
        System.out.println("largest element is "+ largest);
        System.out.println("smallest element is " + smallest);
    }

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length -1;

        while(startRow <= endRow && startCol <= endCol){
            // top boundary
            for(int j=startCol;j<=endCol;j++){
                System.out.print(matrix[startRow][j] + " ");
            }
            // right boundary 
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(matrix[i][endCol] + " ");
            }
            // bottom boundary
            for(int j=endCol-1;j>=startCol;j--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }
            // left boundary
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[i][startCol]+ " ");
            }
            startCol++;
            startRow++;
            endRow--;
            endCol--;
        }
        System.out.println();
    }


    public static int diagonalSum(int matrix[][]) {   
        int sum =0;


        // for(int i=0;i<matrix.length;i++){   // O(n^2)
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(i == j){
        //             // primary diagonal
        //              sum += matrix[i][j];
        //         }
        //         else if(i + j == matrix.length-1){
        //             // secondary diagonal
        //             sum += matrix[i][j];
        //         }
        //     }
        // }


        // optimised code
        for(int i=0;i<matrix.length;i++){   // O(n) time complexity
            // primary diagonal
            sum += matrix[i][i];
            // secondary diagonal
            if (i != matrix.length-i-1)   // for removing the repeated element in first loop for odd numbers
                sum += matrix[i][matrix.length-i-1];
        }
        return sum;
    }

    public static boolean staircaseSearch(int matrix[][], int key) {     // O(n+m) time complexity
        int row =0, col = matrix[0].length-1;

        while(row < matrix.length && col >=0){
            if(matrix[row][col] == key){
                System.out.println("found key at (" + row + "," + col + ")");
                return true;
            }
            else if(key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("key not found!");
        return false;
    }

    public static void main(String args[]) {
        // int matrix [][] = new int[3][3];
        // int n=matrix.length, m=matrix[0].length;

        // // input 
        // Scanner sc = new Scanner(System.in);
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }
        // // output
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(matrix[i][j]+ " ");
        //     }
        //     System.out.println();
        // }

        // // search(matrix, 5);
        // largestAndSmallest(matrix);


        // Spiral Matrix
        // int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        // printSpiral(matrix);


        // Sum of siagonals of a matrix
        // int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        // System.out.println(diagonalSum(matrix));

        // search in sorted matrix
        int matrix[][] = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        int key = 33;
        staircaseSearch(matrix, key);
    }
}
 