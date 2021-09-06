class Solution {
    public int arrayNesting(int[] nums) {
        int visited[] = new int[nums.length];
        int start = 0;
        int max =0;
        /// [1,0]
        for(int i=0; i < nums.length; i++){
            int count = 0;    
            start = i;
            do {
                
                if(visited[start]==1) break; 
                count++;
                visited[start]=1;
                start = nums[start];
                //since nums are within range we won't run in out of bounds error
            } while(visited[start]==0);
            
            max = Math.max(max, count);
        }
        return max;
        }
    }
