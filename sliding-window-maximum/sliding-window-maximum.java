class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int result [] = new int[nums.length - k + 1];
        int r=0;
        Deque<Integer> dq = new LinkedList<>();
        int maxIndex=0;
        for (int i=0; i < k; i++) {
            fix(dq, i, k, nums);
            // first element in the dq should be the highest till this 
            // but we have not added this element so we cannot take it.
            dq.addLast(i);
            maxIndex = nums[dq.getFirst()]>nums[i] ? dq.getFirst():i;          
        }
        
        result[r++]=nums[maxIndex];
        for(int j=k; j<nums.length; j++){
            fix(dq, j, k, nums);
            dq.addLast(j);
            
            maxIndex = nums[dq.getFirst()]>nums[j] ? dq.getFirst():j;
            result[r++]=nums[maxIndex];
        }
        return result;   
    }
    
    public void fix(Deque<Integer> dq, int i, int k, int nums[]){
        
        if(!dq.isEmpty() && dq.getFirst() <= i - k) {
            dq.removeFirst();
        }
        while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]){
            dq.removeLast();
        }
    }
}