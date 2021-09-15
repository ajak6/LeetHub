class Solution {
    public int singleNonDuplicate(int[] nums) {
//         every number should lie on an even index and left to it should be a different element.
        // [5, 5, 6, 6, 7, 8, 8]
        // [0, 1, 2, 3, 4, 5, 6]
        int l = 0;
        int r = nums.length-1;
        
        while(l<r){
            
            int mid = l + (r-l)/2;
            // Mid lands on even index 
                // if mid==mid+1 then the number is in right (left = mid + 1)
                // if mid!=mid+1 then number is left (right = mid - 1)
            // mid lands on odd index
                // either the number is itself
                // mid-1 == mid then number is in right l = mid+1
                // else r=mid;
            
            if(mid%2==0){
                if(nums[mid] == nums[mid+1]) {
                  l = mid+1;      
                } else {
                    r=mid;
                }
            } else {
                if(nums[mid-1] == nums[mid]) {
                  l = mid + 1;      //means the pair is starting from even (correct and this is the second number in the duplicate pair)
                } else {
                    r = mid;
                }
            }
        }
        return nums[l];
    }
}