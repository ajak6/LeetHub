class Solution {
    public boolean canPartition(int[] nums) {
        
        //partition the subset so that sum is target can we partition it
        
        // can be separate any elelemnt from the set.
        
        // for every index i want to know total sum
        // 
        int total = Arrays.stream(nums).sum();
                if (total % 2 != 0) return false;

        Boolean memo [][] = new Boolean [total/2+1][nums.length+1];
        
        return backtrack(nums, 0 , total/2, 0, 0, memo);
        
        //target = sum/2
        
        //we cannot maintain a sum to compare the element can be taken or not
        //
    }
    
    
    //very slow 2^n complexity
    public boolean backtrack(int nums [], int total, int curr, int included, int index, Boolean [][] memo){
        if(index>=nums.length)return false;
        if(curr < total)return false;
            
        if(curr==total && included<nums.length )return true;
        // if(included==nums.length) return false;
        if(memo[curr][index]!= null)return memo[curr][index];
        memo[curr][index]= backtrack(nums, total, curr-nums[index], included+1, index+1, memo) ||
            backtrack(nums, total, curr, included, index+1, memo);
        return memo[curr][index];
    }
}