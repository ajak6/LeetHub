class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //not contain duplicates
        //numbers can be sorted and only pick the last number for a backtrack to start.
        // Can we pick any number of items?
        // suibsets will be any size 0 to nums.length
        // either we create a subnset of length 1 2 3 4 ...
        
        List<List<Integer>> result = new ArrayList<>();
        
        // loop and find all combinations of a lenght from the list
        for(int len =1; len < nums.length+1; len++){
            findSubSetsOfLength(nums, result, 0, len, new LinkedList<>());
        }
        result.add(new ArrayList<>());
        return result;
    }
    
    public void findSubSetsOfLength(int nums[], List<List<Integer>> result, int start, int max, LinkedList<Integer> current){
        
        if(current.size()==max){
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i=start; i< nums.length;i++) {
            current.addLast(nums[i]);
            findSubSetsOfLength(nums,  result, i+1, max, current);
            current.removeLast();
        }
        
        
    }
}