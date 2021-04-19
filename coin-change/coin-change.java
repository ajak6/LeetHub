class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //given coints in sorted order may be.
        // you create array to create every amount and see the min coins required using the given coins.
        
        int dp[] = new int[amount+1]   ;
        Arrays.fill(dp, Integer.MAX_VALUE);
        // for(int coin: coins) {
            
//             dp[coin]=1;
//         }
        dp[0]=0;
        for(int i =1 ; i <= amount; i++){
            
            // dp[i] = find the min coins required to make the i-coin[i] if positive and add 1.
            //at a time you are just adding 1 coint so consider all amounts which can be made by coins[i] and then chose minimum add1
            int min=Integer.MAX_VALUE;
            
            for(int coin: coins){
                if(i-coin>=0){
                    dp[i]=Math.min(dp[i], dp[i-coin]);
                }
            }
            if(dp[i] != Integer.MAX_VALUE){
                dp[i]++; //add 1 coin to make i in the min coin required to make i-coin;
            }
        }
        return dp[amount]==Integer.MAX_VALUE? -1: dp[amount];
        
    }
}