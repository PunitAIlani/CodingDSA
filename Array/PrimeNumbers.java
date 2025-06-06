/*
Given an integer value n, enumerate all prime numbers from 1 to n (exclusive) and return the list with the enumeration.

Input: 1
Output: []
Explanation: 1 is not a prime number
*/
import java.util.*;
class Main {
    public static void main(String[] args) {
        int n = 23;
        boolean[] isPrime = new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        
        List<Integer> output = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            if(isPrime[i])
            {
                for(int j=i+i; j<n; j=j+i)
                {
                    isPrime[j] = false;
                }
                output.add(i);
            }
        }
        
        System.out.println(output);
    }
}