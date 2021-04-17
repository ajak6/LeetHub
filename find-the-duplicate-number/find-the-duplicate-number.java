class Solution {
    public int findDuplicate(int[] nums) {
        /*
        
        hashmap to find duplciate
        traverse n2 times
        sort and trverse nlon and n 
        sort and then binary searhc?
        limts can be helpful
        sorting is but without modifying the array.
        
        */  
        
        int slow = nums[0];
        int fast = nums[0];
        
        // you can traverse from 
        do {
            
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
        
               
    }
}
// [1,3,4,2,2]