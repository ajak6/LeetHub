class Solution {
    Map<Integer, List<Integer>> valueIndex;
    Random r;
    public Solution(int[] nums) {
        valueIndex = new HashMap<>();
        
        for(int i =0 ; i < nums.length ; i++) {
            valueIndex.computeIfAbsent(nums[i], x-> new ArrayList<>()).add(i);
        }
        r=new Random();
    }
    
    public int pick(int target) {
        List<Integer> indexes = valueIndex.get(target);
        return indexes.get(r.nextInt(indexes.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */