import java.util.*;

public class DynamicProgramming {
    public static int fib(int n, int f[]){  // O(n)
        if(n == 0 || n == 1){
            return n;
        }
        if(f[n] != 0){  // fib(n) is alredy calculated
            return f[n];
        }
        f[n] = fib(n-1, f) + fib(n-2, f);
        return f[n];
    }
    public static int fibTabulation(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];  //ans
    }

    // CLimbing Stairs  
    public static int countWays(int n){  //Recursion
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return countWays(n-1) + countWays(n-2);
    }

    public static int countWaysMemoization(int n, int ways[]){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        if(ways[n] != -1){  //already calculated
            return ways[n];
        }
        return countWaysMemoization(n-1, ways) + countWaysMemoization(n-2, ways);
    }

    public static int countWaysTabulation(int n){
        int dp[] = new int [n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            if(i == 1){
                dp[i] = dp[i-1];
            }else{
            dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }


    public static int knapsackUsingRecursion(int val[], int wt[], int W, int n){
        if(W == 0 || n == 0){
            return 0;
        }

        if(wt[n-1] <= W){  //valid
            //include
            int ans1 = val[n-1] + knapsackUsingRecursion(val, wt, W-wt[n-1], n-1);
            //exclude
            int ans2 = knapsackUsingRecursion(val, wt, W, n-1);
            return Math.max(ans1, ans2);
        } else{  // not valid
            return knapsackUsingRecursion(val, wt, W, n-1);
        }
    }


    public static int knapsackUsingMemoization(int val[], int wt[], int W, int n, int dp[][]){
        if(W == 0 || n == 0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n-1] <= W){  //valid
            //include
            int ans1 = val[n-1] + knapsackUsingMemoization(val, wt, W-wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapsackUsingMemoization(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else{  // not valid
            dp[n][W] = knapsackUsingMemoization(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }


    //for printing dp in Tabulation
    public static void print (int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int knapsackUsingTabulation(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int [n+1][W+1];
        for(int i=0;i<n;i++){  // initialize 0th column
            dp[i][0] = 0;
        }
        for(int j=0;j<dp[0].length;j++){  // initialize 0th row
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1];  // ith item val
                int w = wt[i-1];  // ith item wt
                if(w <= j){   //valid
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {   //invalid
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
    }



    
    //function to print boolean 2D array of target sum subset
    public static void printBoolean(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    //Target Sum Subset
    public static boolean targetSumSubset(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        //i = items & j = target sum
        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                //include
                if(v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        printBoolean(dp);
        return dp[n][sum];
    }



    //Unbounded Knapsack
    public static int unboundedKnapSack(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int [n+1][W+1];
        for(int i=0;i<n;i++){  // initialize 0th column
            dp[i][0] = 0;
        }
        for(int j=0;j<dp[0].length;j++){  // initialize 0th row
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1] <= j){   //valid
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                } else {   //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
    }



    //Coin Change
    public static int coinChange(int coins[], int sum){
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        // iniialize - sum is 0
        //i -> coins; j -> sum/change
        for(int i=0;i<n+1;i++){  // initialize 0th column - sum is 0
            dp[i][0] = 1;
        }

        for(int j=1;j<sum+1;j++){  // initialize 0th row
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1] <= j){   // valid
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {               // invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }




      
    //Rod Cutting
    public static int rodCutting(int length[], int price[], int totRod){
        int n = price.length;
        int dp[][] = new int [n+1][totRod+1];
        
        for(int i=0;i<n+1; i++){
            for(int j=0;j<totRod+1;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<totRod+1;j++){
                if(length[i-1] <= j){   //valid
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                } else {   //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][totRod];
    }



    // Longest Common Subsequence
    public static int lcs(String str1, String str2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){  // same
            return lcs(str1, str2, n-1, m-1) + 1;
        } else{   //different
            int ans1 = lcs(str1, str2, n-1, m);
            int ans2 = lcs(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }


    // Longest Common Subsequence Using Memoization
    public static int lcsMemoization(String str1, String str2, int n, int m, int dp[][]){
        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){  // same
            return dp[n][m] = lcsMemoization(str1, str2, n-1, m-1, dp) + 1;
        } else{   //different
            int ans1 = lcsMemoization(str1, str2, n-1, m, dp);
            int ans2 = lcsMemoization(str1, str2, n, m-1, dp);
            return Math.max(ans1, ans2);
        }
    }



    // Longest Common Subsequence Using Tabulation
    public static int lcsTabulation(String str1, String str2){  //Use lcs method written in the book
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }





    //Longest Common Substring
    public static int longestCommonSubstring(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int ans = 0;

        //initialize
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    


    //LCS for Longest Increasing Subsequence
    public static int lcsForlis(int arr1[], int arr2[]){
        int n = arr1.length;
        int m = arr2.length;
        int ans = 0;
        //initialize
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
    //Longest Increasing Subsequence
    public static int lis(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        //set.size()
        int arr2[] = new int[set.size()];   //sorted unique elements
        int i=0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }

        Arrays.sort(arr2);  //ascending
        return lcsForlis(arr, arr2);

    }




    //Edit Distance
    public static int editDistance(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        //initialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i == 0){
                    dp[i][j] = j;
                } 
                if(j == 0){
                    dp[i][j] = i;
                }
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) {   //same
                    dp[i][j] = dp[i-1][j-1];
                } else {   //different
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int rep = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(add, Math.min(del, rep));
                }
            }
        }
        return dp[n][m];
    }





    // String Conversion
    public static int stringConversion(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        //initialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i == 0){
                    dp[i][j] = j;
                } 
                if(j == 0){
                    dp[i][j] = i;
                }
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) {   //same
                    dp[i][j] = dp[i-1][j-1];
                } else {   //different
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    dp[i][j] = Math.min(add, del);
                }
            }
        }
        return dp[n][m];
    }





    // Wildcard Matching - Hard
    public static boolean isMatch(String s, String p){
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        //initialize
        dp[0][0] = true;
        //pattern = " "
        for(int i=1;i<n+1;i++){
            dp[i][0] = false;
        }
        //s = " "
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //case -> ith char == jth char || jth char == ?
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        //string -> n, string -> m
        return dp[n][m];
    }





    //Catalan Number Using Recursion
    public static int catalanRecursion(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        int ans = 0; //Cn
        for(int i=0;i<=n-1;i++){
            ans += catalanRecursion(i) * catalanRecursion(n-i-1);
        }
        return ans;
    }


    //Catalan Number Using Memoization
    public static int catalanMemoization(int n, int dp[]){
        if(n == 0 || n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans += catalanMemoization(i, dp) * catalanMemoization(n-i-1, dp);
        }

        return dp[n] = ans;
    }


    //Catalan Number using Tabulation
    public static int catalanTabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }



    
    //Count no of trees(BSTs)
    public static int countBSTs(int n){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                int leftSubtree = dp[j];
                int rightSubtree = dp[i-j-1];
                dp[i] += leftSubtree * rightSubtree;
            }
        }
        return dp[n];
    }




    //Mountain Ranges
    public static int mountainRanges(int n){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i=2;i<=n;i++){
            // i pairs -> mountain ranges => Ci
            for(int j=0;j<i;j++){
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside * outside;
            }
        }
        // n pairs
        return dp[n];
    }




    //Matrix Chain Multiplication Using Recursion
    public static int mcm(int arr[], int i, int j){
        if(i == j){
            return 0;  // single matrix
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1 = mcm(arr,i,k);  //Ai...Ak   =>  arr[i-1]Xarr[k]
            int cost2 = mcm(arr, k+1, j);  //Ai+1...Aj  => arr[k]Xarr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j]; 
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans, finalCost);
        }

        return ans;  //minCost
    }





    //Matrix Chain Multiplication Using Memoization
    public static int mcmMemoization(int arr[], int i, int j, int dp[][]){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1 = mcmMemoization(arr,i,k,dp);  //Ai...Ak   =>  arr[i-1]Xarr[k]
            int cost2 = mcmMemoization(arr, k+1, j,dp);  //Ai+1...Aj  => arr[k]Xarr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j]; 
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;
    }





    //Matrix Chain Multiplication Using Tabulation
    public static int mcmTabulation(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //initialization
        for(int i=0;i<n;i++){
            dp[i][i] = 0;
        }

        //bottom-up
        for(int length=2; length<=n-1;length++){
            for(int i=1;i<=n-length;i++){
                int j = i+length-1; // column
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        print(dp);
        return dp[1][n-1];
    }







    //Minimum Partioning   //O(n*W)
    public static int minPartition(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }

        int W = sum/2;

        int dp[][] = new int[n+1][W+1];

        //bottom-up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(arr[i-1] <= j){  //valid
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
                } else{  //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }






    //Minimum Array Jumps
    public static int minJumps(int jumps[]){
        int n = jumps.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = 0;

        for(int i=n-2; i>=0; i--){
            int steps = jumps[i];
            int ans = Integer.MAX_VALUE;
            for(int j=i+1;j<=i+steps && j<n; j++){
                if(dp[j] != -1){
                    ans = Math.min(ans, dp[j]+1);
                }
            }
            if(ans != Integer.MAX_VALUE){
                dp[i] = ans;
            }
        }
        return dp[0];
    }



    public static void main(String[] args) {
        // int n = 5;
        // int f[] = new int[n+1];
        // System.out.println(fib(n, f));
        // System.out.println(fibTabulation(n));


        // Climbing Stairs  
        // int n = 5;
        // System.out.println(countWays(n));
        // int ways[] = new int[n+1];
        // Arrays.fill(ways, -1);
        // System.out.println(countWaysMemoization(n, ways));
        // System.out.println(countWaysTabulation(n));


        //0-1 KnapSack using Recursion
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        // System.out.println(knapsackUsingRecursion(val, wt, W, val.length));


        //KnapSack using Memoization
        // int dp[][] = new int[val.length+1][W+1];
        // for(int i=0;i<dp.length;i++){
            // for(int j=0;j<dp[0].length;j++){
                // dp[i][j] = -1;
            // }
        // }
        // System.out.println(knapsackUsingMemoization(val, wt, W, val.length, dp));



        //KnapSack using Tabulation
        // System.out.print(knapsackUsingTabulation(val, wt, W));



        // Target Sum SUbSet
        // int arr[] = {4, 2, 7, 1, 3};
        // int sum = 10;
        // System.out.println(targetSumSubset(arr, sum));



        //Unbounded KnapSack
        // System.out.println(unboundedKnapSack(val, wt, W));


        //Coin Change
        // int coins[] = {2, 5, 3, 6};
        // int sum = 10;  // ans = 5
        // System.out.println(coinChange(coins, sum));


        //Rod Cutting
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};   //pieces length
        int price[] = {1, 5, 8 , 9, 10, 17, 17, 20};
        int totRod = 8;
        // System.out.println(rodCutting(length, price, totRod));




        //Longest Common Subsequence 
        // String str1 = "abcdge";
        // String str2 = "abedg";  // lcs = "abdg"; length = 4
        // System.out.println(lcs(str1, str2, str1.length(), str2.length()));



        //Longest Common Subsequence Using Memoization
        // String str1 = "abcdge";
        // String str2 = "abedg";  // lcs = "abdg"; length = 4
        // int n = str1.length();
        // int m = str2.length();
        // int dp[][] = new int[n+1][m+1];
        // //initialization
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<m+1;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(lcsMemoization(str1, str2, n, m, dp));



        //Longest Common Subsequence Using Tabulation
        // String str1 = "abcdge";
        // String str2 = "abedg"; 
        // System.out.println(lcsTabulation(str1, str2));



        //Longest Common Substring
        // String str1 = "ABCDE";
        // String str2 = "ABGCE";
        // System.out.println(longestCommonSubstring(str1, str2));



        //Longest Increasing Subsequence
        // int arr[] = {50, 3, 10, 7, 40, 80};
        // System.out.println(lis(arr));



        //Edit Distance
        // String str1 = "intention";
        // String str2 = "execution";
        // System.out.println(editDistance(str1, str2));



        // String COnversion
        String str1 = "pear";
        String str2 = "sea";
        // System.out.println(stringConversion(str1, str2));



        //Wildcaed Matching
        String s = "baaabab";
        String p = "*****ba*****ab";
        // System.out.println(isMatch(s, p));




        //Catalan Number using Recursion
        // int n = 4;
        // System.out.println(catalanRecursion(n));




        //Catalan Number using Memoization
        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);
        // System.out.println(catalanMemoization(n, dp));



        //Catalan Number using Tabulation
        // System.out.println(catalanTabulation(n));



        //Count BSTs
        // int n = 4;
        // System.out.println(countBSTs(n));




        //Mountain Ranges
        // int n = 4;
        // System.out.println(mountainRanges(n));




        //Matrix Chain Multiplication Using Recursion
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        // System.out.println(mcm(arr, 1, n-1));





        //Matrix Chain Multiplication Using Memoization
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        // System.out.println(mcmMemoization(arr, 1, n-1, dp));





        //Matrix Chain Multiplication Using Tabulation
        // System.out.println(mcmTabulation(arr));



        
        
        //Minimum Partioning
        int nums[] = {1, 6, 11, 5};
        // System.out.println(minPartition(arr));





        //Minimum Array Jumps
        int jupms[] = {2, 3, 1, 1, 4};
        System.out.println(minJumps(jupms));

          

    }    
}
