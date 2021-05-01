class Solution {
    public int minSteps(int n) {
        int dp [] = new int [n+1]; // you want to reach n so size should be n+1
        
        dp[0] = 0;
        dp[1] = 0;
        int min=n+1;
        for(int i = 2; i <=n ; i++) {
            min=n+1;
            for(int j =i-1; j >=1; j--) {
                
                if(i % j ==0){ // only then we can reach i by pasting j A multipl times.
                    int times = i/j;
                    //dp[j] stores count of copy and paste
                    //I only want to use number of paste it needed
                    // times -number of times j should be pasted since 1 time it is already pasted to create itself.
                    int numberOfPaste = times-1 ; 
                    int copy =1;
                    //dp[j] number of times we took to create j
                    min = Math.min(min, dp[j]+ numberOfPaste + copy);              
                    
                }
                dp[i]=min;
            }
        }
        return dp[n];
        
    }
}