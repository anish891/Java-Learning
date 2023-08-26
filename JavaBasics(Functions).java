import java.util.*;




public class JavaBasics {

    public static void printHelloWorld() {
        System.out.println("Hello World");
    } 

    public static void swap(int a, int b) {
        //swap
    int temp = a;
    a = b;
    b = temp;

    System.out.println("a is " + a);
    System.out.println("b is " + b);
    }


    public static int calculateSum(int a, int b) {   // parametrs or formal parameters
    int sum = a + b;
    return sum;
    }


    public static int multiply(int a, int b) {
        int product = a * b;
        return product;
    }


    public static int factorial(int n) {
        int f = 1;

        for(int i=1;i<=n;i++){
            f = f*i;
        }

        return f;
    }

    public static int binCoeff(int n,int r){
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n-r);

        int binCoeff = fact_n / (fact_r * fact_nmr);
        return binCoeff;
    }

    // function to calculate sum of 2 nos
    public static int sum(int a, int b){
        return a+b;
    }
    public static int sum(int a, int b, int c){
        return a+b+c;
    }
    // above 2 functions are an example of function overloading

    // prime number
    // only for n>=2
    
    public static boolean isPrime(int n) {
        // corner cases
        if(n ==2){
            return true;
        }
        for(int i=2; i<=n-1; i++){
            if(n%i == 0){
                return false;
            } 
        }

        return true;
    }

    public static boolean isPrimeOptimized(int n) {
        if(n==2){
            return true;
        }
        for (int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void primesInRange(int n) {
        for(int i=2;i<=n;i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    // binary to decimal
    public static void binToDec(int binNum) {
        int myNum = binNum;
        int pow = 0;
        int decNum = 0;
        
        while(binNum > 0){
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int)Math.pow(2, pow));

            pow++;
            binNum = binNum/10;
        }
        System.out.println("decimal of " + myNum + " = " + decNum);
    }

    // decimal to binary
    public static void decToBin(int n) {
        int myNum = n;
        int binNum = 0;
        int power = 0;
        while(n>0){
            int rem = n % 2;
            binNum = binNum + (rem * (int)Math.pow(10, power));
            power++;
            n = n/2;
        }
        System.out.println("binary of "+ myNum + " is " + binNum);
    }

    // to check if a number is palindrome or not
    public static void isPalindrome(int x) {
        int palindrome = x;
        int reverse = 0;
        while(palindrome != 0){
            int remainder = palindrome % 10;
            reverse = reverse*10 + remainder;
            palindrome = palindrome/10;
        }
        if(x == reverse){
            System.out.println(true);
        }else{
        System.out.println(false);
        }
    }

    // sum of digits in an integer

    public static void sumOfDigits(int x) {
        int sum =0;
        do {
            int lastDigit = x % 10; 
            sum = sum + lastDigit;
            x = x/10;
        } while (x>0);

        System.out.println(sum);
        
    }

    // average of 3 numbers
    public static int avg(int x,int y,int z) {
        return (x+y+z)/3;
    }


    public static void main(String args[]){
    
        

    // functions/methods - a block of code that can perform a task any number of times

    // Syntax 
    //  retyrnType name (){
    //     body
    //     return statement
    // }

    // printHelloWorld();   // calling the function

    // Scanner sc = new Scanner(System.in);
    // int a = sc.nextInt();
    // int b = sc.nextInt();
    // int sum = calculateSum(a, b);   // a and b are arguments or actual parameters
    // System.out.println("sum is : " + sum);


    // call by value in Java
    // swap - exchange values
    // int a = 5;
    // int b = 10;
    
    // swap(a, b);

    // call by value video of apna college is very important 

    // multiply 
    // int a = 3;
    // int b = 5;
    // int prod = multiply(a, b);
    // System.out.println("a * b = " + prod);


    // factorial of a number n 
    // System.out.println(factorial(4));




    // find binomial coefficient
    // System.out.println(binCoeff(5, 2));


    // function overloading using parameters
    // System.out.println(sum(3, 5));
    // System.out.println(sum(3, 4,1));

    //prime
    // System.out.println(isPrime(5));

    //prime optimized
    // System.out.println(isPrimeOptimized(5));

    //primes in Range
    // primesInRange(20);    // 2 to 20


    // binary to decimal
    // binToDec(101);


    // decimal to binary
    // decToBin(7);


    // palindrome
    isPalindrome(12231);

    /// sum of digits
    // sumOfDigits(4545);

    // // avg of 3 numbers
    // Scanner sc = new Scanner(System.in);
    // System.out.println("ENter num");
    // int x = sc.nextInt();
    // System.out.println("ENter num");
    // int y = sc.nextInt();
    // System.out.println("ENter num");
    // int z = sc.nextInt();

    // System.out.println(avg(x,y,z));



    
    }
}