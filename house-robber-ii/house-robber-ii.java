class Solution {
    
    public int rob(int[] nums) {
        //NO WAY TO KNOW IF 0TH INDEX WAS ROBBED OR NOT: IT IS POSSIBLE THAT VALUE JUST PICKED THE PREV VALUE AS PRODIT AND IN THAT 0TH INDEX WAS NOT ROBBED
        //HAVE A FLAG FOR 0TH INDEX AND YOU ARE PICKING
        //DON'T DO MATH.MAX
        //RATHER DO IF AND IF THAT CONDITION SATISFIES YOU SET THE FLAG FOR THAT POSITION TO TRUE
        //
        if( nums==null || nums.length==0)return 0;
        if (nums.length ==1)return nums[0];
        if (nums.length==2)return Math.max(nums[0], nums[1]);
        
        int max =0;
        boolean [] pickFirst = new boolean[nums.length];
        int dp[]= new int[nums.length];
        dp[0]=nums[0];
        for (int i =1; i < nums.length -1; i++) { 
                dp[i]=Math.max( i-2>=0? dp[i-2] + nums[i] : nums[i], i-1 >= 0 ? dp[i-1] : 0);
        }
        
        max = dp[dp.length-2]; // we are note reaching the last one
        dp = new int[nums.length];
        for(int i=1; i < nums.length; i++ ){
            dp[i]=Math.max(i-2>=0? dp[i-2] + nums[i] : nums[i], i-1 >= 0 ? dp[i-1] : nums[i]);
        }
        max=Math.max(max, dp[dp.length-1]);
        
        return max;
    }
}