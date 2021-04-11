class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        // /n flowers to be placed in k sized array.
        // seems same as task scheduling questions
        // traverse and at each location check if there are zeros near by
        // if there are szeros you place a 1 and move on.
        //if you have placed a location it means it is valid
        //are there any ways in cwhich it can be invalidated?
        //at the end n should be zdero?
        int left =0;
        for(int i = 0 ; n>0 && i < flowerbed.length ; i++){
            //if 0th position is empty and next is also empty
            // [ 0,0,0,1]  -. only 1 can be oplaced chose nay one
            // [0,0,0,0,1] - [1,0,1,0,1] or [0,1,0,0,1] - only 2 can be placed so you have to be greedy to place as many as possible
            // [0,1,0,1,0,0]
            if(flowerbed[i]==0 && left==0 && (i==flowerbed.length-1 || flowerbed[i+1]==0)){
                n--;
                flowerbed[i]=1;
            }
            left= flowerbed[i];
            
            
        }
        return n==0;
    }
}