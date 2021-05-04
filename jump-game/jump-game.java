class Solution {
    public boolean canJump(int[] nums) {
        // we need to know whether we can start from end and reach starting point
        // greedily take the longest jump
        // recursively jump 0 to 0 and then 0 to n
        // do a DFS to reach the by taking every jump possible from every index.
        // take the minimum at the end./
        boolean dp [] = new boolean[nums.length];
        dp[nums.length-1]=true;
        for(int j = nums.length-2; j >= 0; j--) {
            
            int jumps = nums[j];
            for(int i=jumps;i>0;i--) {
                if(i+j<dp.length && dp[i+j]){
                    dp[j]=true;
                    break;
                }
            }
            // System.out.println(Arrays.toString(dp));
            
        }
        // System.out.println(Arrays.toString(dp));
        return dp[0];
            
    }
    
    public boolean canJump2(int[] nums) {
        // backtrack
        // boolean visited[] = new boolean [nums.length];
        return backtrack(nums);
    }
    //bottom up dp
    
    ///last colum is always tru then you check the last second index - > can you reach value which is true - if ye smove to next
    //most efficient
    
    //greedy if you reach the leftmost happy index which can reach the end, then the current index is also happy.
    public boolean backtrack(int nums[]){
        //you only need to find ht elast good poisition, if from the current position you can jump to this position, than current position becomes the happy one
        int happy = nums.length-1;
        int start = happy-1;
        while(start>=0){
            int val = nums[start]; 
            if (start+val >= happy ){
                happy = start;
            }
            start--;
        }
        return happy == 0;
    }
    public boolean backtrack(int nums[] , int start){
        
        boolean dp[] = new boolean[nums.length];
        dp[dp.length-1]=true; //you cal always reach last position from last position
        
        for(int i=dp.length-2; i>=0; i--){
            
            for(int j =nums[i]; j>=0 ;j--){
                
                if(i+j < dp.length && dp[i+j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
    public boolean backtrack(int []nums , int start, boolean visited[]){
        
        // start is your starting index
        int maxJumps = nums[start];
        if(start == nums.length-1){
            return true;
        }
        while(maxJumps>0){
            if(start+maxJumps<nums.length && !visited[start+maxJumps]){
                visited[start+maxJumps]=true;   
                if(backtrack(nums, start+maxJumps, visited)){
                    return true;
                }
            }
            maxJumps--;
        }
        return false;
    }
    
    
    
}