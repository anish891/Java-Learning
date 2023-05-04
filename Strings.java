import java.util.*;

public class Strings {

    public static void printLetters(String str) {
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public static boolean isPalindrome(String str) {
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                // not a palindrome
                return false;
            }
        }
        return true;
    }

    public static float getShortestPath(String path) {   // O(n) time complexity
        int x=0, y=0;

        for(int i=0;i<path.length();i++){
            char direction = path.charAt(i);
            // South
            if(direction == 'S'){
                y--;
            }
            // North
            else if (direction == 'N'){
                y++;
            }
            // West
            else if (direction == 'W'){
                x--;
            }
            // East
            else{
                x++;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2 + Y2);
    }


    public static String subString(String str, int si, int ei) {
        String substr = "";
        for(int i=si;i<ei;i++){
            substr += str.charAt(i);
        }
        return substr;
    }


    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){       // O(n) time complexity
            if(str.charAt(i)  == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } 
            else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compressString(String str) {
        String newStr= "";
        for(int i=0;i<str.length();i++){
            Integer count =1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count > 1){
                newStr += count.toString();
            }
        }
        return newStr;
    }

    public static void main(String args[]) {
        // making a character array and a String
        // char arr[] = {'a', 'b', 'c', 'd'};
        // String str = "abcd";
        // String str2 = new String("xyz23@3");

        // // Strings are IMMUTABLE(not changeable) in Java

        // Scanner sc = new Scanner(System.in);
        // // String name = sc.next();   // takes only one word as input
        // String name = sc.nextLine();   // takes whole line as input
        // System.out.println(name);

        // to find length of a string
        // String fullName = "Anish Tejwani";
        // System.out.println(fullName.length());


        // concatenation of strings
        // String firstName = "Anish";
        // String lastName = "Tejwani";
        // String fullName = firstName + " " + lastName;
        // System.out.println(fullName);
        // System.out.println(fullName.charAt(0));

        // function print letters of a string
        // printLetters(fullName);


        // palindrome strings
        // String str = "racecar";
        // System.out.println(isPalindrome(str));


        // shortest path to reach destination
        // String path = "WNEENESENNN";
        // System.out.println(getShortestPath(path));


        // string comparison
        //  String s1 = "Tony";
        //  String s2 = "Tony";
        //  String s3 = new String("Tony");
        //  if(s1 == s2){
        //     System.out.println("equal");
        //  } 
        //  else{
        //     System.out.println("not equal");
        //  }
        //  if(s1 == s3){   // it gives not equal here
        //     System.out.println("equal");  
        //  } 
        //  else{
        //     System.out.println("not equal");
        //  }
        //  // using .equals function     // it is used to check value
        //  if(s1.equals(s3)){   // it gives equal here
        //     System.out.println("equal");  
        //  } 
        //  else{
        //     System.out.println("not equal");
        //  }


        // substring
        // String str = "Hello World"; 
        // System.out.println(str.substring(0, 5));  // substrinf function already present in Java
        // System.out.println(subString(str, 0, 5));


        // print the largest string
        // String fruits[] = {"apple", "mango", "banana"};
        // String largest = fruits[0];

        // for(int i=1;i<fruits.length;i++){
        //     if(largest.compareToIgnoreCase(fruits[i]) < 0){
        //         largest = fruits[i];
        //     }
        // }
        // System.out.println(largest);


        // StringBuilder
        // StringBuilder sb = new StringBuilder("");
        // for(char ch ='a';ch<='z';ch++){   // O(26) time complexity
        //     sb.append(ch);
        // }
        // System.out.println(sb);
        // System.out.println(sb.length());



        // converting first word of String to Uppercase
        // String str = "hi, i am anish";
        // System.out.println(toUpperCase(str));


        // string compression
        String str = "aaaabbcccdd";
        System.out.println(compressString(str));

    }
}
