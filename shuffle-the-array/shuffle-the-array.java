class Solution {
    public int[] shuffle(int[] nums, int n) {
        /*
            even number of eleemts 
            index of y is at n/2?
            1,2,3,4 4/2 gives the first index after middle points n/2 seems correct
            so you start pointers?
                2,5,1,3,4,7
            ->  2,3,5,1,4,7
            -?  2,3,5,4,1, 7
            
            //in place or take extra space
            
            brute force take extra space.
            pick one index from x and 1 from y
        */
        
        int result [] = new int[2*n];
        
        int i=0; int j=n;
        int k=0;
        while(i<=n && j < 2*n){
            if(k%2==0)
                result[k++] = nums[i++];
            else
                result[k++] = nums[j++];
            
            
            
        }
        return result;
    }
}