class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        //can numbers be negative?
        //care about out of range?
        //range is 1 to N to we can use these numbers as the index.
        // 1 to N so they should map to 1-1 to N-1 indexes in the array
        //if I am allowed to modify the array
        List<Integer> res = new ArrayList<>();
        // [3,1,2,2]
        // [2,1,2,3] => [0,1,-2,3]
            //either convery all numbers negatiove and once you find naother make it positive: this makes it hard to traver them
            //as index can cause bugs
            //while i != a[i] || a[i]!=0
            // if(a[i] == i)
            // if(a[i] != i) means a[i] is at wrong location-> temp=a[a[i]]= a[i]=temp;
            // 
            //a[i]==i - a[i]=-a[i];
        
        //if -a[i]==i duplicate
        //if a[i]!=i -> temp=a[a[i]] a[a[i]]=a[i] a[i]=temp ->loop until a[i]!=i a[i] startsfrom 1 i from 0 so a[i]==i-1
        for (int i=0; i<nums.length; i++) {
            while(nums[i]>0 && nums[i] != i + 1) {    
                int temp = nums[nums[i]-1];
                if(temp==nums[i]) {
                    res.add(temp);
                    nums[i]=0;
                    break;
                }
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        return res;
    }
}