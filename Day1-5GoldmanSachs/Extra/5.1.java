// https://www.geeksforgeeks.org/super-ugly-number-number-whose-prime-factors-given-set/

// Super Ugly Number 
// (Number whose prime factors are in given set)

// M-1: based on nthUglyNumber

package Extra;
import java.util.PriorityQueue;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int ptr[] = new int[m];
        
        
        for(int b = 1; b<n; b++){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i<m; i++){
                int num = dp[ptr[i]]*primes[i];
                if(min>num){
                    min=num;
                }
            }
            
            dp[b] = min;
            
            for(int i = 0; i<m; i++){
                int num = dp[ptr[i]]*primes[i];
                if(min==num){
                    ptr[i]++;
                }
            }
        }
        
        return dp[n-1];
    }
}

// M-2: Priority Queue

class info implements Comparable<info>{
    int num;
    int ptr;
    int value;
    
    public info(int num, int ptr, int value){
        this.num = num;
        this.ptr = ptr;
        this.value = value;
    }
    
    public int compareTo(info o){
        return this.value - o.value;
    }
}

class Solution2 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int dp[] = new int[n];
        dp[0] = 1;
        
        PriorityQueue<info> pq = new PriorityQueue<>();
            
        for(int i = 0; i<m; i++){
            info ele = new info(primes[i], 0, primes[i]);
            pq.add(ele);
        }
        
        for(int b = 1; b<n;){    
            info frNode = pq.remove();
            
            if(dp[b-1] != frNode.value){
                dp[b] = frNode.value;
                b++;
            }
            
            pq.add(new info(frNode.num, frNode.ptr+1, dp[frNode.ptr+1]*frNode.num));
        }
        
        return dp[n-1];
    }
}