import javax.swing.text.StyledEditorKit.BoldAction;

public class RecursionBasics {
    public static void printDecreasing(int n) {
        if (n==1){
            System.out.println(1);
            return;
        }
        System.out.print(n + " ");
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n) {
        if (n==1){
            System.out.print(1);
            return;
        }
        printIncreasing(n-1);
        System.out.print(n + " ");
    }

    public static int factorial(int n) {
        if (n == 0){
            return 1;
        }
        int fnm1 = factorial(n-1);
        int fn = n * fnm1;
        return fn;
    }

    public static int calculateSumUpton(int n) {
        if (n == 1){
            return 1;
        }
        int Snm1 = calculateSumUpton(n-1);
        int Sn = n + Snm1;
        return Sn;
    }

    public static int fibonnaci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int fnm1= fibonnaci(n-1);
        int fnm2= fibonnaci(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    public static boolean isSorted(int arr[], int i) {
        if(i == arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }

        return isSorted(arr, i+1);
    }

    public static int firstOccurence(int arr[], int key, int i) {
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }

        return firstOccurence(arr, key, i+1);
    }

    public static int lastOccurence(int arr[], int key, int i) {
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOccurence(arr, 5, i+1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }

    public static int power(int x, int n) {      // O(n) time complexity
        if(n == 0){
            return 1;
        }
        // int xnm1 = power(x, n-1);
        // int xn = x * xnm1;
        // return xn;
        return x * power(x, n-1);
    }

    public static int optimizedPower(int a, int n) {   // O(logn) time complexity
        if(n == 0){
            return 1;
        }
        int halfPower = optimizedPower(a, n/2);
        int halfPowerSquare = halfPower * halfPower;
        // n is odd
        if(n % 2 != 0){
            halfPowerSquare = a * halfPowerSquare;
        }
        return halfPowerSquare;
    }

    public static int tilingProblem(int n) {   // 2 x n (floor size)
        // base case
        if(n == 0 || n==1){
            return 1;
        }
        // work
        // vertical choice
        int fnm1 = tilingProblem(n-1);

        // horizontal choice
        int fnm2 = tilingProblem(n-2);

        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    public static void removeDuplicates(String str, int index, StringBuilder newStr, boolean map[]) {
        // base case
        if(index == str.length()){
            System.out.println(newStr);
            return;
        }

        // kaam
        char currChar =str.charAt(index);
        if(map[currChar-'a'] == true){
            // duplicate
            removeDuplicates(str, index+1, newStr, map);
        } else {
            map[currChar-'a'] =true;
            removeDuplicates(str, index, newStr.append(currChar), map);
        }

    }

    public static int friendsPairing(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        // choice 
        // single
        // int fnm1= friendsPairing(n-1);

        // // pair 
        // int fnm2= friendsPairing(n-2);
        // int pairWays= (n-1) * fnm2;

        // // total ways
        // int totalWays = fnm1 + pairWays;
        // return totalWays;


        // totlal funtion code written in one line
        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    public static void printBinaryStrings(int n, int lastPlace, String str) {
        

        // // kaam 
        // if(lastPlace == 0){
        //     // place 0  on chair n
        //     printBinaryStrings(n-1, 0, str.append("0"));
        //     printBinaryStrings(n-1, 1, str.append("1"));
        // } else {
        //     printBinaryStrings(n-1, 0, str.append("0"));
        // }

        // base case
        if(n == 0){
            System.out.println(str);
            return;
        }
        // kaam
        printBinaryStrings(n-1, 0, str+"0");
        if(lastPlace == 0){
            printBinaryStrings(n-1, 1, str+"1");
        }
    }
    public static void main(String[] args)  {
        // print no from n to 1 in decreasing order
        // int n = 10;
        // printDecreasing(n);

        // print no from 1 to n in increasing order
        // int n = 10;
        // printIncreasing(10);

        // print factorial of a number
        // int n = 5;
        // System.out.println(factorial(n));

        // print sum of n natural numbers
        // int n = 5;
        // System.out.println(calculateSumUpton(n));

        // print Nth fibonacci
        // int n = 25;
        // System.out.println(fibonnaci(n));

        // check if an array is sorted or not
        // int arr[] = {1, 2, 3, 4};
        // System.out.println(isSorted(arr, 0));

        // find first occurence of an element in an array
        // int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        // System.out.println(firstOccurence(arr, 5, 0));

        // find last occurence of an element in an array
        // int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        // System.out.println(lastOccurence(arr, 5, 0));
        
        // calculate x to the power n
        // System.out.println(power(2, 10));

        // // calculate x to the power n (optimized)
        // System.out.println(optimizedPower(2, 5));

        // tiling problem
        // System.out.println(tilingProblem(30));

        // remove duplicates in a string
        // String str = "appnnacollege";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

        // // friends pariring
        // System.out.println(friendsPairing(3));

        // print binary strings
        printBinaryStrings(3, 0, "");

    }
}
