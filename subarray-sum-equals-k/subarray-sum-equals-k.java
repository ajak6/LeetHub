class Solution {
    public int subarraySum(int[] nums, int k) {
        //number can be negative that is a minus
        
        //total subarrays whos sum is equal to m
        // find the sum of sumarrays
//         leftand right pointer 
//             since there are negatives it may not work
//             keep going right and create the sum
           // what if we create the sum array
               // then use left and right pointer to create 
               // sum of negative numer reduces as we move to right and keep adding netagive numebrs
        
        int sum[] = new int[nums.length+1];
        sum[0]=0;
        for(int i=0;i<nums.length; i++){
            
            sum[i+1] = sum[i] + nums[i];
        }
        
        int count =0;
        for(int i=0;i < sum.length; i++) {
            
            for(int j = i+1; j < sum.length ; j++) {
                if(sum[j] - sum[i] == k) count++;
            }
        }
        return count;
            
    }
}