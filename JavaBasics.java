import java.util.*;


public class JavaBasics {

    public static void main(String args[]){

        basics of output in Java
        System.out.print("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");


        // print pattern 
        System.out.println("****");
        System.out.println("***");
        System.out.println("**");
        System.out.println("*");


        // variables in java
        int a = 10;
        int b = 5;
        String name = "Anish";
        System.out.println(a);
        System.out.println(name);

        a = 50;
        System.out.println(a);

        a = b;
        System.out.println(a);


        // datatypes in Java
        byte x = 8;
        System.out.println(x);
        char ch = 's';
        System.out.println(ch);
        boolean var = true;
        // float price = 10.5;
        int number = 25;
        // long
        // double
        short n = 240;

        // sum of 2 variables 
        int d = 10;
        int e = 5;
        int sum = d + e;
        System.out.println(sum);


        
        input in Java
        Scanner sc = new Scanner(System.in);   
        String input = sc.next();       // captures anything before first space
        System.out.println(input);

        Scanner sc = new Scanner(System.in); 
        String input = sc.nextLine();    // for printing beyond space
        System.out.println(input);

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(input);

        Scanner sc = new Scanner(System.in);
        float price = sc.nextFloat();
        System.out.println(price);



        Sum of a and b take input from user

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum =  a +  b;
        System.out.println(sum);




        Product of a and b take input from user

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int product =  a *  b;
        System.out.println(product);



        Area of a circle take radius as input from user

        Scanner sc = new Scanner(System.in);
        float r = sc.nextFloat();
        float area =  3.14f*r*r ;   // Java automatically considers decimal as double type // here f is used to refer 3.14 as float
        System.out.println(area);



        type conversion in Java
        int a = 25;          // this conversion is possible
        long b = a;
        System.out.println(b);

        long a = 25;         
        int b = a;                 // this type of conversion is not possible
        System.out.println(b);

        Scanner sc = new Scanner(System.in);             
        int number =  sc.nextFloat();                     // incompatible types: possible lossy conversion from float to int
        System.out.println(number);

        Scanner s = new Scanner(System.in);
        float num = s.nextFloat();
        System.out.println(num);


        type casting in Java

        Scanner sc = new Scanner(System.in);
        float a = 25.12f;
        // int b = a;   // this will give error
        int b = (int) a;    // typecasting wiil remove value after decimal that is only 25 will be stored as value of b
        System.out.println(b);

        char ch = 'a';
        char ch2 = 'b';
        int b = ch;    // here b will hold ascii value of a i.e 97
        int nm2 = ch2;   // here ch2 will hold ascii value of b i.e 98
        System.out.println(b);
        System.out.println(nm2);



        type promotion in expressions in Java
        char a = 'a';
        char b = 'b';
        System.out.println((int) a);  // a is converted to int
        System.out.println((int) b);  // b is converted to int
        System.out.println(b-a);      // both a and b are automatically converted to int  // type promotion is only done in expressions

        short a = 5;
        byte b = 25;
        char c = 'c';
        byte bt = (byte) (a + b + c);
        System.out.println(bt);

        int a = 10;
        float b = 20.25f;
        long c = 25;
        double d = 30;
        double ans = a + b + c + d;
        System.out.println(ans);

        byte b = 5;
        byte a = (byte) (b * 2);
        System.out.println(a);

        average of 3 numbers
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        System.out.println((num1 + num2 + num3)/3);

        

        area of a square
        Scanner sc = new Scanner(System.in);
        int side = sc.nextInt();
        int area = side * side;
        System.out.println(area);



        bill of items
        Scanner sc =  new Scanner(System.in);
        float i1 = sc.nextFloat();
        float i2 = sc.nextFloat();
        float i3 = sc.nextFloat();

        float total = (i1 + i2 +i3);
        float bill = total + 0.18f*total;
        System.out.println(bill);

        int $ = 23;        // this does not give any error beacuse identifier can start with underscore or dollar
        System.out.println($);




       

        operators in Java
        
        arithmetic operators
        int A = 10;
        int B = 5; 
        System.out.println("sum = " + (A+B));
        System.out.println(A-B);
        System.out.println(A*B);
        System.out.println(A/B);
        System.out.println(A%B);


        unary operators

        int a = 10;
        int b = ++a;
        System.out.println(a);   // pre-increment 
        System.out.println(b);

        int a = 10;
        int b = a++;
        System.out.println(a);   // post-increment 
        System.out.println(b);

        int a = 10;
        int b = --a;
        System.out.println(a);   // pre-idecrement 
        System.out.println(b);

        int a = 10;
        int b = a--;
        System.out.println(a);   // post-idecrement 
        System.out.println(b);



        if-else statements
        int age = 16;
        if(age >= 18) {
            System.out.println("Adult : drive, vote");
            }
        if (age >= 13 && age < 18){
            System.out.println("Teenager");
        }    
        else{
            System.out.println("Not Adult");
        }



        print the largest of 2 numbers
        int A = 10;
        int B = 5;

        if (A>= B){
            System.out.println("A is largest of 2");
        } else {
            System.out.println("B is largest of 2");
        }


        print if a number is odd or even
        Scanner sc =  new Scanner(System.in);
        int number = sc.nextInt();

        if (number % 2 ==0){
            System.out.println("EVEN");
        } else {
            System.out.println("ODD");
        }



        else-if statements
        int age = 13;
        
        if (age >= 18){
            System.out.println("Adult");
        } else if (age >= 13 && age < 18){
            System.out.println("Teenager");
        } else {
            System.out.println("Child");
        }



        income tax calculator
        Scanner sc = new Scanner(System.in);
        int income = sc.nextInt();
        int tax;

        if(income < 50000){
            tax = 0;
        } else if (income >= 50000 && income < 1000000){
            tax = (int) (income * 0.2);
        } else {
            tax = (int) (income * 0.3);
        }
        System.out.println("Your tax is:" + tax);



        print the largest of 3 numbers
        int A = 1, B = 3, C = 6;
        if ((A>=B) && (A>=C)){
            System.out.println("largest is A " + A);
        } else if (B>=C){
            System.out.println("largest is B " + B);
        } else {
            System.out.println("largest is C " + C);
        }



        ternary operator
        uses 3 operands
        // variable = condition? statement1 : statement2;
        int number = 4;

        //ternary operator
        String type = ((number%2) == 0)? "even":"odd";
        System.out.println(type);


        check if a student will pass or fail
        int marks = 67;

        String RC = marks>= 33? "pass":"fail";
        System.out.println(RC);



        
        // switch statement 
        int number = 2;
        switch(number){
            case 1 : System.out.println("Samosa");
                    break;
            case 2 : System.out.println("Burger");
                    break;
            case 3 : System.out.println("Mango Shake");
                    break;
            default : System.out.println("We wake up");
        }


        // calculator using switch statements
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a : ");
        int a = sc.nextInt();
        System.out.println("Enter b : ");
        int b = sc.nextInt();
        System.out.println("Enter operator : ");
        char operator = sc.next().charAt(0);

        switch(operator){
            case '+' : System.out.println(a+b);
                  break;
            case '-' : System.out.println(a-b);
                  break;
            case '*' : System.out.println(a*b);
                  break;  
            case '/' : System.out.println(a/b);
                  break;          
            case '%' : System.out.println(a%b);
                  break;      
            default : System.out.println("Wrong operator");
        }





        basics of loops in Java
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");

        while loop

        printing Hello World 100000 times using while loop
        int counter = 0;
        while(counter<100000){
            System.out.println("Hello World");
            counter++;
        }
        System.out.println("Printed Hello World 100000 times");

        
        print numbers from 1 to 10
        int counter = 1;
        while(counter <= 10){
            System.out.println(counter+" ");
            counter++;
        }


        print numbers from 1 to n
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();
        int counter = 1;
        while(counter <= range){
            System.out.print(counter + " ");
            counter++;
        }

        
        print sum of first n natural numbers
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        int i = 1;
        while(i <= n){
            sum += i;
            i++;
        }
        System.out.println("sum is : " + sum);


        for loops

        for(int i=1;i<=10;i++){
            System.out.println("Hello World");
        }

        print square pattern
        for(int line =1; line<=4;line++){
            System.out.println("****");
        }
        int line =1;
        while(line<=4){
            System.out.println("****");
            line++;
        }

        
        print reverse of a number
        int n = 10899;
        while(n>0){
            int lastDigit = n%10;
            System.out.print(lastDigit);
            n/=10;
        }


        reverse the given number
        int n = 10899;
        int reverse = 0;

        while(n>0){
            int lastDigit = n%10;
            reverse = (reverse*10) + lastDigit;
            n/=10;
        }
        System.out.println(reverse);



        do while loop
        int counter = 1;
        do{
            System.out.println("Hello World");
            counter++;
        } while(counter <= 10);

        // break statement - to exit the loop
        for(int i =1;i<=5;i++){
            if(i == 3){
                break;
            }
            System.out.println(i);
        }
        System.out.println("I am out of the loop");

        keep entering numbers until user enters a multiple of 10
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter your number");
            int n = sc.nextInt();
            if(n%10 == 0){
                break;
            }
            System.out.println(n);
        } while(true);


        continue statement - to skip a statement
        for(int i =1;i<=5;i++){
            if(i==3){
                continue;
            }
            System.out.println(i);
        }

        display all numbers entered by user except multiples of 10
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Enter your number : ");
            int n = sc.nextInt();
            if(n%10 == 0){
                continue;
            }
            System.out.println("number was : " + n);
        }while(true);


        check if a number is prime or not
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n == 2){
            System.out.println("n is prime");
        } else {
        boolean isPrime = true;
        for(int i=2;i<=Math.sqrt(n);i++){   // using square root of n to reduce time complexity
            if(n%i == 0){
                isPrime = false;
            }
        }
        if(isPrime == true){
            System.out.println("n is prime");
        } else{
            System.out.println("n is not prime");
        }
    }



    program to find multiplication table of number entered by user
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number : ");an
    int n = sc.nextInt();
    for(int i=1;i<=10;i++){
        System.out.println(n+" * "+i+" = "+n*i);
    }


    to find factorial of a number
    Scanner sc = new Scanner(System.in);
    int num;
    int fact = 1;
    System.out.println("Enter the number : ");
    num = sc.nextInt();
    
    for(int i=1;i<=num;i++){
        fact = fact*i;
    }
    System.out.println(fact);


    nested loops

    print star pattern
    for(int line =1;line<=4;line++){
        for(int star=1;star<=line;star++){
            System.out.print("*");
        }
        System.out.println();
    }


    inverted star pattern
    int n =4;
    for(int line=1;line<=n;line++){
        for(int stars=1;stars<=n-line+1;stars++){
            System.out.print("*");
        }
        System.out.println();
    }

    print half pyramid pattern
    int n = 4;
    for(int line=1;line<=n;line++){
        // numbers print
        for(int number=1;number<=line;number++){
            System.out.print(number);
        }
        System.out.println();
    }

    
    print character pattern
    int n=4;
    char ch = 'A';

    for(int line=1;line<=n;line++){
        for(int chars=1;chars<=line;chars++){
            System.out.print(ch);
            ch++;
        }
        System.out.println();
    }



    }
}
