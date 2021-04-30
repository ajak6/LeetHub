class Solution {
    public int combinationSum4(int[] nums, int target) {
           
        
        /*
        number of possible combinations to reach target. 
        order does not matter 
        a number can be reused
        you can do a dfs for each number and keep increasing it
        but if we do this way we willl not bne able to exclude 
        start 1 - 2 = 3
        start 2 - 1 =3
        it should be counted as 1
        
        recursively you chose target -> 
        ways(n) = ways(n-1) + ways(n-2)....+ways(n-n)
        */
        // [1,2,3] => ways(n-get(0)) + ways(n-get(1)) + ways(n-get(n))
        
        int dp [] = new int [target+1];
        dp[0]=1;
        for(int i= 1; i < dp.length; i++) {
            
            
            for(int j= 0; j < nums.length;j++){
                if(nums[j]> i) continue;
             else {
                    int idx = i- nums[j];
                    dp[i]+= dp[idx];
                }
                    
            }
        }
        return dp[target];
        
            
    }
    
    
}