class Solution {
    public int findPeakElement(int[] nums) {
        int left = Integer.MIN_VALUE;
        
      for(int i=0 ;i< nums.length -1 ; i++) {
        
          if (left < nums[i] && nums[i] > nums[i+1]) {
              return i;
          }
            left=nums[i];
      }
        return nums.length-1;
    }
}