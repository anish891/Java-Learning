import java.util.*;

public class BitManipulation {

    public static void oddOrEven(int n) {
        int bitmask = 1;
        if((n & bitmask) == 0){
            // even number
            System.out.println("even number");
        } else{
            // od number 
            System.out.println("odd number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitmask = 1<<i;
        if((n & bitmask) == 0){
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitmask = 1<<i;
        return n | bitmask;
    }
    
    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1<<i);
        return  n & bitmask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if (newBit == 0){
        //     clearIthBit(n, i);
        // } else{
        //     setIthBit(n, i);
        // }

        // 2nd logic
        n = clearIthBit(n, i);
        int bitmask = newBit<<i;
        return n | bitmask;
    }
    
    public static int clearIBits(int n, int i) {
        int bitmask = ((~0)<<i);
        return n & bitmask;
    }

    public static int clearRangeOfBits(int n,int i, int j) {
        int a = (~0)<<(j+1);
        int b = (1<<i) -1;
        int bitmask = a | b;
        return n & bitmask;
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while(n>0){
            if((n & 1) != 0){  // chech our LSB
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastExponentiation(int a, int n) {
        int ans =1;

        while(n>0){
            if((n & 1) != 0){  // chech our LSB
                ans *= a;
            }
            a *= a;
            n = n >> 1 ;
        }
        return ans;
    }


    public static void main(String args[]) {

        // bitwise operators

        // binary AND
        // System.out.println((5&6));

        // binary OR
        // System.out.println((5|6));

        // binary XOr
        // System.out.println((5^6));

        // binary 1's Complement
        // System.out.println((~0));

        // binary left shift
        // System.out.println((5<<2));

        // binary right shift
        // System.out.println((6>>1));

        // check if a number os odd or even
        // oddOrEven(467);
        // oddOrEven(24);

        //get Ith bit
        // System.out.println(getIthBit(10, 2));

        // set Ith bit
        // System.out.println(setIthBit(10, 2));

        // clear Ith bit
        // System.out.println(clearIthBit(10, 1));

        // update Ith Bit
        // updateIthBit(10, 2, 1);

        // clear I bits
        // System.out.println(clearIBits(15, 2));

        // clear range of bits
        // System.out.println(clearRangeOfBits(10 , 2, 4));

        // check if a number is a power of 2 or not
        // System.out.println(isPowerOfTwo(15));

        // count the number of set bits
        // System.out.println(countSetBits(10));

        // fast Exponentiation
        System.out.println(fastExponentiation(3, 5));

    }
}
