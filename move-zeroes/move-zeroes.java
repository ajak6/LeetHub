class Solution {
    public void moveZeroes(int[] nums) {
     
        int l= nums.length;
        int r=0;
        while(r<nums.length){
            if(nums[r]==0){
                l=r;break;
            }
            r++;
        }
         r=l+1;
        for(int i=r; r< nums.length;){
            
            if (nums[r] != 0) {
                nums[l++] = nums[r];
                nums[r]=0;
            }
            r++;
        }
        
    }
}