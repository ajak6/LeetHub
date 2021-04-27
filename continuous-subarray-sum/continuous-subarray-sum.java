class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int left =0;
        
        if(nums==null || nums.length<2)return false;
        int sum[]=new int[nums.length+1];
        int s=0;
        sum[0]=0;
        for(int i=0; i < nums.length ; i++){
            sum[i+1] = left+nums[i];
            left=sum[i+1];
        }
        System.out.println(Arrays.toString(sum));
        
        left =0;
        
        for(int i=0;i< sum.length; i++){
            sum[i]=sum[i]%k;
        }
        System.out.println(Arrays.toString(sum));
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i< sum.length; i++){
            System.out.println(k-sum[i]);
            
            if(map.containsKey(sum[i])){
                if( i-map.get(sum[i]) >1) return true;
            }
            map.putIfAbsent(sum[i], i);
        }
        return false;
        
        
        //atleast 2 ekements 
        //it can be more than 2 elements
        //for nums we need to take care for all the sums.
        //either what if we keep doing a modulo on every operation and maontain a sum
        //28%6 = 4 + 2 is 6
        //30% 6 is also multiple so adding the number to x or x%6 will give te same result.
        
        
        
    }
}