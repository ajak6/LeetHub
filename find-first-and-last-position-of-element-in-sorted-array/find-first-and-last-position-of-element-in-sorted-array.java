class Solution {
    //cases missed
    /*
    1. single element in the array since left< right it always returned -1
    2. When left and right go equal and that is where the target balue is, the look does not set the 
    boolean flag to true and you always return -1 like 1,1,5 target 5
    */
    public int[] searchRange(int[] nums, int target) {

        //find the first elemeent
        //find the last element
        
        //left and right
        //if mid is target make right at mid
        //if mid is smaller make left+1
        //that way you will land at the smallest index of target?>
        
        //left would be the smallest index where target is presnt
        //to find the highest
        //if mid is  target then move left here 
        //if mid is smaller then left+1
        //if mid higher than right -1
        //mid should be ceiling of left+right/2
        
        int left =0;
        int right =nums.length-1;
        boolean found =false;
        while(left < right){
            //[1,2,3,3,3,3,3,3,3,3]
            int mid = left + (right -left)/2;
            if(nums[mid]>=target){
                right=mid;
                if(target==nums[mid])found=true;
            } else {
                left=mid+1;
            }
        }
        if(left<nums.length && nums[left]==target) found=true;
        int r[] = new int[2];
        r[0]=found ? left : -1;
        left =0;
        right =nums.length-1;
        found =false;
        while(left < right) {
            //[1,2,3,3,3,3,3,3,3,3]
            int mid = (int) Math.ceil(left + 1.0*(right -left)/2);
            System.out.println("mid "+ mid);
            if (nums[mid] > target) {
                right = mid-1;  
            } else if (nums[mid] ==target) {
                left=mid;
                found=true;
            } else {
                left=mid+1;
            }
        }
        if(left<nums.length && nums[left]==target) found=true;
        r[1]=found ? left : -1;
        return r;
        
        
    }
}