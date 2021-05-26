class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0)return 0;
        int r=nums.length-1;
        int len = nums.length;
        
        while(r>=0 && nums[r]==val) {
            r--;
            len--;
        }
            
        int l = 0;
        for(; l <= r; l++){
            if(nums[l]==val){
                nums[l]=nums[r];
                len--;
                r--;
            }
            while(nums[r]==val){
                r--;
                len--;
            }
            
        }
        return len;
        
    }
}