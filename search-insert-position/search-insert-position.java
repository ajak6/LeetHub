class Solution {
    public int searchInsert(int[] nums, int target) {
        int l =0 ;
        int r = nums.length;
        //cases: nums.length helps wi th single element array and helps in going inside the loop for single size aerray
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target)return mid;
            if(nums[mid] < target) {
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}