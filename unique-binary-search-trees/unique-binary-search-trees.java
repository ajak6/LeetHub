class Solution {
    public int numTrees(int n) {
        
        
        if(n<3){
            return n<2?1:2;
        }
        //bottom calculation
        int dp [] = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        dp[2]=2;
        
        //to have 3 nodes as BST
        // we don't have to backtrack if only count is asked
        // for n
        /*
        for i-> 1 to n
        make every i as root
        then search how many ways to arrange a BST in left and right
        i-1 elements in the left(smaller)
        n- i+1 elements in the right(larger)
        do it for all numbers will give you count of ways
        */    
        
        for(int i=3; i <=n;i++) {
            for(int j=1;j<=i;j++) {
                //make j as root and find left ways
                //make j as root and find ways for nodes current max we are lookng for and the number which we have selected as root under that range
                //1 - dp[0]*dp[3-1] + dp[1]*dp[1] + dp[2]+dp[0
                // 2+1+2
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
            
        return dp[n];
        
    }
}