class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        //are there duplicates? can those be used if they are on different index
        // are there duplicates?
        // care about overflow since we are taking sums?
        // since target is int sum which overflows can be risky and integer overflow can return a false result
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0 ; i < nums.length; i++){
            // int diff =
            if(map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }
            map.put( target - nums[i], i);
        }
        return new int[0];
    }
    
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> twoSum = new HashMap<>();
        for(int i =0 ; i < nums.length ; i++) {
            
            if(twoSum.containsKey(nums[i])) return new int[]{i, twoSum.get(nums[i])};
            twoSum.put(target - nums[i], i);
            
        }
        return new int[0];
    }
    
    public int[] twoSum3(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i < nums.length ;i++) {
            
            if(map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);    
        }
        return new int[]{ };
    }
//     public int[] twoSum(int[] nums, int target) {
        
//         //find the index/
//         Map<Integer, List<Integer>> store = new HashMap<>();
//         //reverse number to index. in case of duplicates?
        
//         //if answer is unique then it 
//         // 
//         // now you traverse and get the index of number of ot os not same you store 
//         for(int i =0; i < nums.length; i++) {
//             store.computeIfAbsent(nums[i], (x)-> new ArrayList<>()).add(i);
//         }
//         int result[] = new int[2];
//         for(int i =0 ; i < nums.length  ; i++){
            
//             if(store.containsKey(target-nums[i])) {
//                 List<Integer> index=store.get(target-nums[i]);
//                 if(index==null) continue;
//                 if(index.size() > 1) {
                    
//                     return new int[]{index.get(0), index.get(1)};
//                     // return result;
//                 } else if(index.get(0) != i) {
//                     return  new int[]{index.get(0), i};
//                 }
//             }
//         }
//         return result;
//     }
    
    
}