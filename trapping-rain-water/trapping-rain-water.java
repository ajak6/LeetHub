class Solution {
    public int trap(int[] height) {
        
        // for each index we want to know
        // how many wewant to find height of water./
        // for every index if we know the heighest point
        // you take the min and max
        
         // at each point we know what is max in left and max in right
         
        //when wefind a non zero heigh you say that is your length/
        // now you move to the right if the next height is smaller yo
        // add count += count-curr[i];
        //when the height is higher than the current t means we need to stop
        //
        // keep going until you hit something higher than your self and collect water as you go. WHen you hit you
        //if we use a stack pick a height and put it in the stack.
        //if you get a height smaller you push it on stack
        //when you hit a element higher you pop the elements but 
        // we will know how much water should we put?
        // lets store the elements index in thestack  you take out the index
        // check the value: I know my height but that does not help because how much water 
        // thecurrent height and stack.peek can store: until we know the other enclosing heigh we will not know. what if we keep track of max height we have seen in the stack and its index. but still any bumps in between will not be address if you just use the max.
        // subproblem? at every point i will search in left and right for max increasing heignt/ which ever is small I add that heught in 
        //since this is recursive call I can storeit>?
        int right[] = new int [height.length];
        if(height==null || height.length ==0 || height.length ==1) return 0;
        int maxh=height[height.length-1];
        right[right.length-1] = 0;
        //[1,2,3,6,0]
        //[6,6,6,0,-inf]
        for(int i=height.length-2; i>=0; i--){
            right [i] = Math.max(height[i+1], right[i+1]);
        }
        int left [] = new int[height.length];
        left[0] = 0;
        for(int i =1 ; i < height.length; i++){
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        int total =0;
        System.out.println(Arrays.toString(left));
        
        System.out.println("Right " + Arrays.toString(right));
        for(int i =0 ; i < height.length; i++){
            
            int minSorroundingHeight = Math.min(left[i], right[i]);
            // System.out.println("minn "+ minSorroundingHeight);
            //won't be -inf from both array.if it is size 1 
            if(minSorroundingHeight- height[i]>0){
                total+=minSorroundingHeight- height[i];
            }
            
        }
        return total;
    }
}