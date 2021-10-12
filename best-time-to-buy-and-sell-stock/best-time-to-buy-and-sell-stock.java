class Solution {
     public int maxProfit(int[] prices) {
         //to decide to buy or sell
         //we need to pick the latest price and see if we have a lowest price before
         int min = prices[0];
         int max = 0;
         
         for(int i=1; i  < prices.length; i++){
            max=Math.max(prices[i]-min, max);
            min=Math.min(min, prices[i]);   
         }
         return max;
     }
    
//     public int maxProfit1(int[] prices) {
//         //[7,1,5,3,6,4]
//         // take 1 and diff with all oters and find the max diff after it.
//         // for a number you want to find the max number greater than it 
//         // 
//         // for an index we want to know what the max number after it and take the diff
//         int max []=new int[prices.length];
//         max[max.length-1]=0;
//         int maxAfter = 0;
//         for(int i=max.length-1; i>0;i--) {
//             maxAfter = Math.max(maxAfter, prices[i]);
//             max[i-1] = maxAfter;
//         }
//         int maxProfit = 0;
//         for (int i=0;i<max.length;i++) {
//             maxProfit = Math.max(maxProfit, max[i]-prices[i]);
//         }
            
//         return maxProfit;
        
//     }
}