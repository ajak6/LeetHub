class Solution {
    public int largestRectangleArea(int[] h) {
        
        // at a index if I know 
        //if we hit a number smaller than whats on the top of array
        // we keep popping all numbers higher than current element and count the numbers
        // now ever number will have its index and we calculate the area 
        //inded when we start poping which that is defnitely contribute ion the area
        // then calculate its area
        // then pop and take pop*2 because that is bound to be sma;er than first pop friom the stack
        //then pop again and multiply it with the counter of how many we have poped and store tha max seen.
        //keep doing it/ if you reach the end at the last number then push in the stac k
        //then try to empty the stack by calculating the area
        //for every number we want to find the farthest number which is equal or greater without any dips
        // for a specific number wwe want a incresing subarray lengthh so that 
        // for 2 we want to know in the irhg that 2 has 6,5,1 in the left to use similarly
        //if we have 1 at the ned. we need to know that this 1 can include all elelemtns to the left sinc ethere is not lement smaller than it in the left.
        // a number cares about the closest index of number which is smaller than it.
        // n s  uare time to calculate for each number and but that does not heop
        // for 6 will it be 5 or 1 ? I think 6 needs to look at all numbers in its left and right to caculate the area
        // abnother approach is  on each index keep expanding in left and right and find the area with larger of 2 and current
        // 6 look at 5 and 2 2 will take 5,6,2 giving 6 as area. for 5 you can only include 5 and 6 and then for how long we will expand like this.
        // case 1: 
        // case 2: 
        int left []  = new int[h.length];
        int right[] = new int[h.length];
        left[0]=-1;
        for(int i =1; i < h.length; i++){
            
            int j=i-1;
            while(j>=0 && h[i]<= h[j]){
                j=left[j];
            }
            left[i]=j;
        }
        right[h.length-1]=h.length;
        for(int i = h.length - 2; i >=0 ; i--) {            
            int j = i + 1;
            while( j < h.length && h[i]<= h[j]) {
                j=right[j];
            };
            
            right [i]=j;
        }
        
        int maxArea = 0;
        for(int i=0; i < h.length; i++) {
            maxArea = Math.max(maxArea, h[i]*(right[i] - left[i] - 1 ));
        }
        return maxArea;
    }
}