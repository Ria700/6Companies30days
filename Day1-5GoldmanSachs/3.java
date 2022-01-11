// https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1/#

// Count the SUBARRAYS having product less than k

// Given an array of positive numbers, the
// task is to find the number of possible 
// contiguous subarrays having product less 
// than a given number k.

// User function Template for Java

class Solution {
    
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        int count = 0;
        long p = 1;
        int st = 0, en = 0;
        
        while(en<n){
            p*= a[en];
            
            while(st<en && p>=k){
                p/=a[st++];
            }
            
            if(p<k){
                count+=(en-st+1);
            }
            
            en++;
        }
        
        return count;
        
    }
}
