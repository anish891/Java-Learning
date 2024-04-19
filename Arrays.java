import java.util.*;


public class Arrays {

    public static void update(int marks[]) {
        for(int i=0;i<marks.length;i++){
            marks[i] = marks[i] + 1;
        }
    }

    
    public static int linearSearch(int numbers[] , int key) {
        for(int i =0;i<numbers.length;i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static int getLargest(int numbers[]) {
        int largest = Integer.MIN_VALUE;   // storing the minimum integer value possible in Java  (- infinity)
        int smallest = Integer.MAX_VALUE;
        for(int i=0;i<numbers.length;i++){
            if(largest<numbers[i]){
                largest = numbers[i];
            }
            if(smallest>numbers[i]){
                smallest = numbers[i];
            }
        }
        System.out.println("smallest value is : "+ smallest);
        return largest;
    }


    public static int binarySearch(int numbers[], int key) {
        int start = 0, end = numbers.length - 1;

        while(start<=end){
            int mid =  (start + end)/2;

            // comparisons
            if(numbers[mid] == key){
                return mid;
            }
            if(numbers[mid] < key){ // right
                start = mid + 1;
            } else{                 // left
                end = mid - 1; 
            }
        }
        return -1;
    }


    private static void reverse(int numbers[]) {
        int first = 0, last = numbers.length-1;

        while(first < last){
            // swap
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;
            first++;
            last--;
        }
    }


    public static void printPairs(int numbers[]) {
        int totalPairs = 0;
        for(int i=0;i<numbers.length;i++){
            int curr = numbers[i];  // 2, 4, 6, 8, 10
            for(int j=i+1;j<numbers.length;j++){
                System.out.print("(" + curr + "," + numbers[j] + ") ");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("total pairs = "+ totalPairs);    // total pairs = (n*(n-1))/2
    }

    public static void printSubarrays(int numbers[]) {
        int totalSubarrays = 0;
        for(int i=0;i<numbers.length;i++){
            int start = i;
            for(int j=i;j<numbers.length;j++){
                int end = j;
                int x=0;
                for(int k=start;k<=end;k++){  // print
                    System.out.println(numbers[k] + ","); // subarray
                }
                System.out.println(x);
                totalSubarrays++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("The total number of SubArrays is" + totalSubarrays);    // total pairs = (n*(n+1))/2
    }


    public static void maxSubarraySum(int numbers[]) {  // time complexity is O(n^3)  // brute force approach
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0;i<numbers.length;i++){
            int start = i;

            for(int j=i;j<numbers.length;j++){
                int end = j;
                int currentSum = 0;
                for(int k=start;k<=end;k++){  
                    currentSum += numbers[k];  // print subarray sum
                }
                System.out.println(currentSum);
                if(maxSum < currentSum){
                    maxSum = currentSum;
                }
            }
        }
        System.out.println("max sum = " + maxSum);
    }

    public static void maxSubarraySumUsingPrefixSumMethod(int numbers[]) {    // optimised appraoch
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0]=numbers[0];
        // calculate prefix array
        for(int i=1;i<prefix.length;i++){
            prefix[i]= prefix[i-1] + numbers[i];
        }
        
        for(int i=0;i<numbers.length;i++){
            int start = i;
            for(int j=i;j<numbers.length;j++){
                int end = j;
                int currentSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1] ;
                // for(int k=start;k<=end;k++){  
                //     currentSum += numbers[k];  // print subarray sum
                // }
                // System.out.println(currentSum);
                if(maxSum < currentSum){
                    maxSum = currentSum;
                }
            }
        }
        System.out.println("max sum = " + maxSum);
    }
    public static void kadanesAlgorithmMaximumSubArraySum(int numbers[]) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<numbers.length;i++){
            currentSum += numbers[i];
            if(currentSum < 0){
                currentSum = 0;
            } else{
                maxSum = Math.max(maxSum, currentSum);
            }
            
        }
        System.out.println("maximum subarray sum is : "+ maxSum);
    }

    public static int trappedRainWater(int height[]) {    // O(n) time complexity
        int n = height.length;
        // calculate left max boundary - array
        int leftMax[] = new int[n];
        leftMax[0]= height[0];
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }


        // calculate right max boundary - array
        int rightMax[] = new int[n];
        rightMax[n-1]= height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        // loop
        for(int i=0;i<n;i++){
            // water level - min(left max boundary, right max boundary)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // trapped water = water level - height[i]
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;

    }


    public static int buyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0;i<prices.length;i++){    // O(n) time complexity
            if(buyPrice < prices[i]){  // profit
                int profit = prices[i] - buyPrice;   // today's profit
                maxProfit = Math.max(maxProfit, profit); 
            } else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }


    public static boolean distinctElement(int nums[]) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-1;j++){
            if(nums[i] == nums[j]){
                return true;
            } 
        }
    } return false;
    }
    


    public static void main(String args[]){
        // Craeting an array
        // int mark[] = new int[50];    // by default empty array

        // // creating an array
        // int numbers[] = {1,2,3};

        // taking input in an array
        // int marks[] = new int[100];
        // Scanner sc = new Scanner(System.in);
        // marks[0] = sc.nextInt();   // phy
        // marks[1] = sc.nextInt();   // chem
        // marks[2] = sc.nextInt();   // math

        // System.out.println("phy : "+ marks[0]);
        // System.out.println("chem : "+ marks[1]);
        // System.out.println("math : "+ marks[2]);

        // // update in arrays 
        // marks[2] = marks[2] + 1;
        // System.out.println("math : "+marks[2]);
        // int percentage = (marks[0] + marks[1] + marks[2])/3;
        // System.out.println("percentage = "+ percentage + "%");

        // printing length of array
        // System.out.println("length of array = " + marks.length);



        // passing arrays as argument 
        // int marks[] = {97,98,99};
        // // update function
        // update(marks);
        // // print our marks
        // for(int i=0;i<marks.length;i++){
        //     System.out.print(marks[i] + " ");
        // }
        // System.out.println();


        // linear search
        // int numbers[] = {2, 4, 6, 8, 10, 12, 14, 16};
        // int key = 14;
        // int index = linearSearch(numbers, key);
        // if(index == -1){
        //     System.out.println("NOT FOUND");
        // } else{
        //     System.out.println("key is at index : " + index );
        // }


        // largest in an array
        // int numbers[] = {1, 2, 6, 3, 5};
        // System.out.println("largest value is : "+ getLargest(numbers)
        
        
       // binary search 
    //    int numbers[] = {2, 4, 6, 8, 10, 12, 14};
    //    int key = 10;
    //    System.out.println("index for key is : "+ binarySearch(numbers, key));


      // reverse an array
    //   int numbers[] = {2, 4, 6, 8, 10};
    //   reverse(numbers);
    //   // print the reversed array
    //   for(int i=0;i<numbers.length;i++){
    //     System.out.print(numbers[i] + " ");
    //   }
    //   System.out.println();


    // print pairs in an array
    // int numbers[]={2, 4, 6, 8, 10};
    // printPairs(numbers);


    // print subarrays in an array
    // int numbers[]={2, 4, 6, 8, 10};
    // printSubarrays(numbers);
    
    // print sum of subarray
    // int numbers[] = {1, -2, 6, -1, 3};
    // maxSubarraySum(numbers);

    // print max sum of sub array using prefix array
    // int numbers[] = {1, -2, 6, -1, 3};
    // maxSubarraySumUsingPrefixSumMethod(numbers);

    // print max sum of subarray using kadane's algorithm
    // int numbers[] = {-2, -3, 4, -1, -2, 1, 5, -3};
    // kadanesAlgorithmMaximumSubArraySum(numbers);


    // trapping rain water problem
    // int height[] = {4, 2, 0, 6, 3, 2, 5};
    // System.out.println(trappedRainWater(height));
    

    // best time to buy and sell stock
    // int prices[] = {7, 1, 5, 3, 6, 4};
    // System.out.println(buyAndSellStocks(prices));



    // distinct elements
    int nums[] = {1, 2, 3, 1};
    System.out.println(distinctElement(nums));

    }
}
