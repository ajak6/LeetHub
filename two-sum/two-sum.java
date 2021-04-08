class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //find the index/
        Map<Integer, List<Integer>> store = new HashMap<>();
        //reverse number to index. in case of duplicates?
        
        //if answer is unique then it 
        // 
        // now you traverse and get the index of number of ot os not same you store 
        for(int i =0; i < nums.length; i++) {
            store.computeIfAbsent(nums[i], (x)-> new ArrayList<>()).add(i);
        }
        int result[] = new int[2];
        for(int i =0 ; i < nums.length  ; i++){
            
            if(store.containsKey(target-nums[i])) {
                List<Integer> index=store.get(target-nums[i]);
                if(index==null) continue;
                if(index.size() > 1) {
                    
                    return new int[]{index.get(0), index.get(1)};
                    // return result;
                } else if(index.get(0) != i) {
                    return  new int[]{index.get(0), i};
                }
            }
        }
        return result;
    }
}