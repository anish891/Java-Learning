import java.util.*;
import java.util.ArrayList;
public class Stacks {

    // static class Node {
    //     int data;
    //     Node next;
    //     Node(int data){
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    // static class Stack{
        // static ArrayList<Integer> list = new ArrayList<>();
        // // isEmpty function
        // public static boolean isEmpty() {
        //     return list.size() == 0;
        // }

        // // push
        // public static void push(int data){
        //     list.add(data);
        // }

        // // pop
        // public static int pop() {
        //     if(isEmpty()){
        //         return -1;
        //     }
        //     int top = list.get(list.size()-1);
        //     list.remove(list.size()-1);
        //     return top;
        // }

        // // peek
        // public static int peek() {
        //     if(isEmpty()){
        //         return -1;
        //     }
        //     return list.get(list.size()-1);
        // }
        // stack using ArrayList


    //     static Node head = null;

    //     // isEmpty
    //     public static boolean isEmpty(){
    //         return head == null;
    //     }
    //     // push
    //     public static void push(int data){
    //         Node newNode = new Node(data);
    //         if(isEmpty()){
    //             head = newNode;
    //             return;
    //         }
    //         newNode.next = head;
    //         head = newNode;
    //     }

    //     // pop
    //     public static int pop() {
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }

    //     // peek
    //     public static int peek() {
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }


    // push at the bottom of Stack
    public static void pushAtBottom(Stack <Integer> s, int data) {
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);    // O(n)
        s.push(top);
    }

    // reverse String using Stack
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int index = 0;
        // adding in the Stack
        while(index < str.length()){
            s.push(str.charAt(index));
            index++;
        }

        // removing from the Stack
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    // reverse a stack
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top  = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    // print a stack
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    // Stock Span Problem
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i=1;i<stocks.length;i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            } else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }


    // Valid Parentheses
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            // opening
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }
            else{
                // closing
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
                        s.pop();
                } else {
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        } else{
            return false;
        }
    }


    // Duplicate Parentheses
    public static boolean isValidParentheses(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0;i<str.length();i++){
           char ch = str.charAt(i);
           //closing
           if(ch == ')'){
            int count = 0;
            while(s.peek() != '('){
                s.pop();
                count++;
            }
            if(count < 1){
                return true;
            } else{
                s.pop();
            }
           }
           else{
            // opening
            s.push(ch);
           }
        }
        return false;
    }



    // Max Rectangular ARea in Histogram
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];      // Next Smaller Right
        int nsl[] = new int[arr.length];      // Next Smaller Left

        // Next Smaller Right 
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            } else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // Next Smaller Left
        s = new Stack<>();

        for(int i=0; i<arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            } else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        // Current Area : width = j-i-1 = nsr[i]-nsl[i]-1
        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("max area in histogram = " + maxArea);
    }



    public static void main(String args[]) {
        // Stack s = new Stack();
        // Stack<Integer> s = new Stack<>();  // Stack using Java Collection Framework
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // push at the bottom of a Stack
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // pushAtBottom(s, 4);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }

        // reverse a String using a Stack
        // String str = "abc";
        // String result = reverseString(str);
        // System.out.println(result);


        // reverse a stack
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // reverseStack(s);
        // printStack(s);




        // stock span problem
        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);

        // for(int i=0; i<span.length;i++){
        //     System.out.println(span[i]+" ");


        // next Greater element

        // int arr[] = {6, 8, 0, 1, 3};
        // Stack<Integer> s = new Stack<>();
        // int nextGreater[] = new int[arr.length];

        // for(int i=arr.length-1; i>=0; i--){
        //     // 1 while
        //     while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
        //         s.pop();
        //     }

        //     // 2 if-else
        //     if(s.isEmpty()){
        //         nextGreater[i] = -1;
        //     } else{
        //         nextGreater[i] = arr[s.peek()];
        //     }

        //     // 3 push in Stack
        //     s.push(i);
        // }

        // for(int i=0; i<nextGreater.length; i++){
        //     System.out.println(nextGreater[i]+" ");
        // }
        // System.out.println();




        // Valid Parentheses 
        // String str = "({})[]";
        // System.out.println(isValid(str));



        
        // Duplicate Parentheses
        // String str = "((a+b))";  // true
        // String str2 = "(a-b)";  // false
        // System.out.println(isValidParentheses(str2));


        
        // Max Rectangular ARea in Histogram
        int arr[] = {2, 1, 5, 6, 2, 3};   // heights in histogram
        maxArea(arr);
    }
}
 