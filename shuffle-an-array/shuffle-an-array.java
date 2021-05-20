class Solution {
    int original[];
    Random r = new Random();
    public Solution(int[] nums) {
        original = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        //get the orignal array and move around the elements
        // for each index generate a random number and copy it it.
        int maxLength = original.length;
        int result [] = new int[original.length];
        for(int i =0;i<original.length; i++){
            result[i]=original[i];
        }
        //shuffe
        for(int i=maxLength-1; i>0; i--){
            int index = r.nextInt(maxLength);
            // swap this index with end and reudce the shuffle space
            
            int temp = result[i];
            result[i]=result[index];
            result[index]=temp;
            maxLength--;
        }
        return result;
        
        
        
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */