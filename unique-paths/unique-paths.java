class Solution {
    public int uniquePaths(int m, int n) {
        //do dfs until you reach the target back track try other possibility
        // will you migh visit some nodes again just 1 node might be different
        //so it will be higher than n2
        //if we store the paths possible from start to end
        
        // on every index we can travel to 2 locations
        // at every box I can reach from multiple places and I need to update
        // the count
        // at every index we are counting way to reach the starting point.
        // 
        int dp[][] = new int[m][n];
        for(int i =0 ; i < m; i++){
            
            for(int j=0; j < n; j++){
                if(i==0 && j==0) dp[0][0]=1;
                else{
                    if(i-1>=0) dp[i][j] += dp[i-1][j];
                    if(j-1>=0) dp[i][j] += dp[i][j-1];    
                }
                
                
            }
        }
        return dp[m-1][n-1];
        
            
        
    }
}