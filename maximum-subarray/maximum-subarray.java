class Solution {
    public int maxSubArray(int[] nums) {
         // int sum[] = new int[nums.length+1];
        long runningSum=0;
        long minSum = 0;
        long max=Integer.MIN_VALUE;
        for(int i=0;i < nums.length;i++) {
            runningSum += nums[i]; //-2 -1
            max = Math.max(runningSum - minSum, max);//-2 1
            minSum=Math.min(minSum, runningSum); //0 or -2
        }
        
        return (int)max;
        
    }
    
    public int maxSubArray22(int[] nums) {
        // [-2,1,-2,4,-1,2,1,-5,4] => [-2, -1, -3, 1, 0, 2, 3, -2, 2]
        int sum[] = new int[nums.length+1];
        for(int i=0; i < nums.length ; i++){
            sum[i+1] = sum[i]+nums[i];
        }
        // System.out.println(Arrays.toString(sum));
        // int max = Integer.MIN_VALUE;
//         for(int i=0 ; i  < sum.length; i++) {
            
//             for(int j=i+1; j < sum.length ; j++) {
//                 max = Math.max(max, sum[j]-sum[i]);
//             }
//         }
        int min = sum[0];
        int max = Integer.MIN_VALUE;
        
        for(int i=1; i < sum.length; i++) {
            max = Math.max(max, sum[i]- min);
            min = Math.min(min, sum[i]);
                
        }
        return max;
    }
    
    
    public int maxSub2Array(int[] nums) {
        int sum [] = new int[nums.length+1];
        // int maxSum = Integer.MIN_VALUE;
        sum[0]=0;
        //what if you just track the lowest sum till you have seen and keep taking the max between new sums you are seeing?
        int minsum=0;
        for (int i=1; i<sum.length; i++) {
            sum[i]=sum[i-1]+nums[i-1];
            // minsum=Math.min(minsum, sum[i]);
            // maxSum=Math.max(minsum, sum[i]-minsum);
            
        }
        
        // now sum array stores all your sum up until a location.it is possible that the sums are negative.
        // so you can do 2 pointers on this sub array 
        // sum[right]-sum[left];
        /*
        
        you increase right
        for each elft keep increasing right and take differenfce so that you find the sum at each and find the max
        
        if for each element we keep taking the diff then 1--2 wil be 3 but sun is -1
        */
        
        // int maxSum=sum[0];
        // System.out.println(Arrays.toString(sum));
        // same as buy and sell stock problem. where you just maintain the lowest sum you have seen
        //keep taking the diff with the sum till here.
        //minSum= 0initial value means sum includes all element start from 0 in original array. if we have a negative sum
        //it means we will
        int maxSum=Integer.MIN_VALUE;
        int minSum = sum[0]; // 0
        for (int i=1; i < sum.length; i++) {            

            maxSum=Math.max(maxSum, sum[i]-minSum);
            minSum  = Math.min(minSum, sum[i]);
        
        }
        return maxSum;
        /* optimize */
        
        
        
        
        
    }
}