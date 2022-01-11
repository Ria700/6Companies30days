// https://practice.geeksforgeeks.org/problems/ugly-numbers2254/1/

// Ugly Numbers

// Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
// The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the 
// first 11 ugly numbers. By convention, 1 is included. 
// Write a program to find Nth Ugly Number.

// M-2
class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
        int i = 0, j = 0, k = 0;
        long dp[] = new long[n];
        
        dp[0] = 1;
        for(int a = 1; a<n; a++){
            long p2 = dp[i]*2;
            long p3 = dp[j]*3;
            long p5 = dp[k]*5;
            
            long min = Math.min(Math.min(p2, p3), p5);
            dp[a] = min;
            
            if(p2==min) i++;
            if(p3==min) j++;
            if(p5==min) k++;
        }
        
        return dp[n-1];
        
    }
}

// M-1: Brute Force: MAx ivide 2, 3 & 5
// M-3: TreeSet: poolfirst() stores the min of added elements