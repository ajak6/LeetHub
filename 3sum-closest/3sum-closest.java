class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //try to find the sum which is equalt to target by sorting and select 1 and then looking for vbalues foir other array.
        // to find the closest sum you prolly need to find all possible sums of 3 numbers and see which is one comes out to be closest. 
            /*
            some optimization can be done when avoiding duplicates.
            for pick1
                for pick1
                    for pick1 n3 complexity.
                    
            */
            /*
                if we sort the array then judging that we are getting closer to our target or moving away will be more easier.
                once sorted select and search of left over in the array. this only gives some optimization since 
                we will have to search half the array  but with same complexity. selecvt 1 and search for all sums ain left mover array. that may not possible with binary search?
                after sorting we can do 2 pointer approach of starting from boths endds and comparintg with target/
                rtime complexity will be onlog + n2
                
         
         */
        
        // [-4, -1 , 1, 2]
        // -4 
        Arrays.sort(nums);
        int answer=0;
        int maxDiff=Integer.MAX_VALUE;
        for(int i =0 ; i < nums.length-2 ;i++){
            
            int first = nums[i];
            
            int result = find2Sum(first, i+1, nums, target);
            int maxDiffNew = Math.min(maxDiff, Math.abs(result - target));
            if(maxDiffNew< maxDiff){
                maxDiff = maxDiffNew;
                answer=result;
            }
        }
        return answer;
    }
    
    public int find2Sum(int first, int start, int nums[], int target){
        
        int  l=start, r=nums.length-1;
        int maxDiff = Integer.MAX_VALUE;
        // if(start>= nums.length-1) return maxDiff;
        int result = 0;
        while(l<r) {
            int sum= first + nums[l] + nums[r];
            int maxDiff1 = Math.min(maxDiff, Math.abs(target- sum));
            if(maxDiff1<maxDiff){
                maxDiff = maxDiff1;
                result = sum;
            }
            if(sum<target){
                l++;
            }else{
                r--;
            }
        }
        return result;
        
    }
}