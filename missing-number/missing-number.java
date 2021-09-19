class Solution {
    public int missingNumber(int[] nums) {
        //exor with all numbers with i
        int reuslt =0;
        
        // if we put event number at its index and swap that number to current index and keeop doing it.
        //eventuall we will never land at some number but how will we know that number: the current value at that index will be positive.
        //swpa and -ve all the numbers,
        //ionce you find that value->
        //length is how many numbers there should be.
        //in actual the actual value might be 1 larger
        //e.g. [0,1]-> length is 2 so 2 ismissing since range is 0-n, it can also be 0,2 and we say 1 ismissing.
        //to do exor 0 to n 
        int result=nums[0] ^0;
        for(int i=1; i < nums.length ; i++){
            result=result^nums[i] ^i;
        }
        result=result^nums.length;
        return result;
        
    }
}