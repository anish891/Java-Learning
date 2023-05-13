
public class OOPS {
    public static void main(String[] args) {
        // Pen p1 = new Pen();   // created a pen object called p1
        // p1.setColor("Blue");
        // System.out.println(p1.getColor());
        // p1.setTip(5);
        // System.out.println(p1.getTip());
        // // p1.setColor("Yellow");
        // p1.setColor("Yellow");
        // System.out.println(p1.getColor());


        // BankAccount myacc = new BankAccount();
        // myacc.username = "anishTejwani";
        // myacc.password = "abcdefghi";   // cannot change password as it is private
        // myacc.setPassword("abcdefghi");    // can be use as it is declared inside a function


        // for COnstructor  
        // Student s1 = new Student("Anish");
        // System.out.println(s1.name);

        // types of constructor
        // Student s2 = new Student("Anish");
        // Student s1 = new Student();
        // // Student s3 = new Student(123);
        // // Student s4 = new Student("anish", 123);   // this will give errors
        // s1.name = "Anish";
        // s1.roll = 123;
        // s1.password = "abcd";
        // s1.marks[0] = 100;
        // s1.marks[1] = 90;
        // s1.marks[2] = 80;

        // Student s2 = new Student(s1); // all properties of s1 should be copied by s2 // copy
        // s2.password= "xyz";
        // s1.marks[2] = 100;
        // for(int i=0;i<3;i++){
        //     System.out.println(s2.marks[i]);
        // }
        

        // inheritance
        // Fish shark =  new Fish();
        // shark.eat();

        // Dog dobby = new Dog();
        // dobby.eat();
        // dobby.legs = 4;
        // System.out.println(dobby.legs);


        // method overloading
        // Calculator calc = new Calculator();
        // System.out.println(calc.sum(1, 2));
        // System.out.println(calc.sum((float)1.5, (float)2.5));
        // System.out.println(calc.sum(1, 2, 3));

        // method overriding
        // Deer d = new Deer();
        // d.eat();


        // abstraction 
        // Horse h = new Horse();
        // h.eat();
        // h.walk();
        // System.out.println(h.color);

        // Chicken c = new Chicken();
        // c.eat();
        // c.walk();

        // Animal a = new Animal() {};   // will give an error because Animal is an abstract class

        // Mustang myHorse = new Mustang();
        // // Animal -> Horse -> Mustang


        // interfaces
        // Queen q = new Queen();
        // q.moves();


        // static keyword
        // Student s1 = new Student();
        // s1.schoolName = "JMV";

        // Student s2 = new Student();
        // System.out.println(s2.schoolName);

        // Student s3 = new Student();
        // s3.schoolName = "ABC";

        // super keyword
        Horse h = new Horse();
        System.out.println(h.color);
    }
}

// class BankAccount {
//     public String username;
//     private String password;
//     public void setPassword(String pwd) {
//         password = pwd;
//     }
// }

// class Pen {   // In Java name of class starts with a capital letter
//     private String color;
//     private int tip;

//     String getColor() {
//         return this.color; 
//     }

//     int getTip(){
//         return this.tip;
//     }

//     void setColor(String newColor){
//         color = newColor;
//     }       
//     void setTip(int newTip){
//         tip = newTip;
//     }
// }

// class Student {
//     String name;
//     int age;
//     float percentage;

//     void calcPercentage(int phy, int chem, int math){
//         percentage = (phy + chem + math)/3;
//     }
// }


// constructors
// class Student {
//     String name;
//     int roll;
//     String password;
//     int marks[];

    // shallow copy constructor
    // Student(Student s1){  // cpoy constructor
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     this.marks = s1.marks;
    // }
    // deep copy constructor
//     Student(Student s1){
//         marks = new int[3];
//         this.name = s1.name;
//         this.roll = s1.roll;
//         for(int i=0;i<marks.length;i++){
//             this.marks[i] = s1.marks[i];
//         }
//     }

//     Student(String name) {   // Parameterized Constructor 
//         marks = new int[3];
//         this.name = name;
//     }
//     Student() {   //  Non-Parameterized Constructor 
//         marks = new int[3];
//         System.out.println("constructor is called...");
//     }
//     Student(int roll) {   //  Non-Parameterized Constructor 
//         marks = new int[3];
//         this.roll = roll;
//     }
// }


// base class
// class Animal{
//     String color;
//     void eat(){
//         System.out.println("eats");
//     }
//     void breathe(){
//         System.out.println("breathes");
//     }
// }

// class Mammal extends Animal{
//     void walk(){
//         System.out.println("walks");
//     }
// }

// class Dog extends Mammal{
//     String breed;
// }
// class Fish extends Animal{
//     void swim(){
//         System.out.println("swim");
//     }
// }
// class Bird extends Animal{
//     void fly(){
//         System.out.println("fly");
//     }
// }


//derived class
// class Fish extends Animal{
//     int fins;

//     void swim(){
//         System.out.println("swims in water");
//     }
// }

// class Calculator{
//     int sum(int a, int b){
//         return a+b;
//     }

//     float sum(float a, float b){
//         return a+b;
//     }

//     int sum(int a, int b, int c){
//         return a+b+c;
//     }
// }


// method overriding 
// class Animal{
//     void eat(){
//         System.out.println("eats anything");
//     }
// }
// class Deer extends Animal{
//     void eat(){
//         System.out.println("eats grass");
//     }
// }



// abstraction
// abstract class Animal{
//     String color;
//     Animal(){
//         System.out.println("animal constructor called");
//     }

//     void eat(){
//         System.out.println("animal eats");
//     }

//     abstract void walk();   // abstract methods do not have implementation
// }
// class Horse extends Animal{
//     Horse(){
//         System.out.println("Horse constructor called");
//     }
//     void ChangeColor(){
//         color = "dark brown";
//     }
//     void walk(){
//         System.out.println("walks on 4 legs");
//     }
// }
// class Mustang extends Horse{
//     Mustang(){
//         System.out.println("constructor called");
//     }
// }
// class Chicken extends Animal{
//     void ChangeColor(){
//         color = "yellow";
//     }
//     void walk(){
//         System.out.println("walks on 2 legs");
//     }
// }



// interfaces
// interface ChessPlayer{
//     void moves();
// }

// class Queen implements ChessPlayer{
//     public void moves(){
//         System.out.println("up, down, left, right, diagonal (in all 4 directions) ");
//     }
// }

// class Rook implements ChessPlayer{
//     public void moves(){
//         System.out.println("up, down, left, right ");
//     }
// }

// class King implements ChessPlayer{
//     public void moves(){
//         System.out.println("up, down, left, right, diagonal (by 1 step)");
//     }
// }


// static keyword
// class Student{
//     static int returnPercentage(int math, int phy, int chem){
//         return(math+phy+chem)/3;
//     }
//     String name;
//     int roll;

//     static String schoolName;

//     void getName(String name){
//         this.name = name;
//     }
//     String getName(){
//         return this.name;
//     }
// }


// super keyword
class Animal{
    String color;
    Animal(){
        System.out.println("animal constructor is called");
    }
}
class Horse extends Animal{
    Horse(){
        super();  // used to call constructor of animal class
        super.color = "brown";
        System.out.println("horse constructor is called");
    }
}