class Solution {
    //case missed : if you sort and count you will miss the case with duplicates
    // 0, 1, 1, 2, 3 -> you need to count
    public int longestConsecutive(int[] nums) {
        //for each number pick the number 1 lower and get its lenth and add 1 to it
        //that lower number will loop to find a number lower than it and recures for that number,
        // always go in small direction?
        //sort the array and traverse counting the consevutive sequence
        //check n and n-1 have a diff of 1 then start counting 2= and keep checking
        //if dtops reset count =1 and continue;
        if(nums==null || nums.length==0)return 0;
        Arrays.sort(nums);
        int count =1;
        int max =0;
        // System.out.println(Arrays.toString(nums));
        for(int i=1; i < nums.length;i++){
            
            if(nums[i-1]+1 == nums[i]){
                count++;
            }else if(nums[i-1]==nums[i]) continue;
            else{
                max=Math.max(max, count);
                count=1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}