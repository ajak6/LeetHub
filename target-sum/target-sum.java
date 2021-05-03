class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        /*
        
        */
        
        // Store the count and  
        // On every index you know the sum
        int a[]=new int[1];
         ways(nums, 0, 0, target, a);
        return a[0];
    }
Map<Integer,Integer>memo=new HashMap<>();
    //make how many times you see a value
    //how many ways to reach 1 cusing all elements but
    public int ways(int nums[], int i, int curr, int tar, int count[]){
        
        if(i==nums.length && curr==tar){
            count[0]++;
            return 0;
        }
        if(i==nums.length)return 0;
        
        int one = ways(nums,i+1, curr+nums[i],tar,count);
        int two = ways(nums, i+1, curr-nums[i],tar,count);
        return one+two;
            
    }
}