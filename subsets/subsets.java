class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //not contain duplicates
        //numbers can be sorted and only pick the last number for a backtrack to start.
        // Can we pick any number of items?
        // suibsets will be any size 0 to nums.length
        // either we create a subnset of length 1 2 3 4 ...
        
        List<List<Integer>> result = new ArrayList<>();
        
        // loop and find all combinations of a lenght from the list
        //make subsets of len 1 then len 2 etc
        
        findSubSetsOfLength(nums, result, 0, new LinkedList<>());
        
        
        return result;
    }
    public void findSubSetsOfLength(int nums[], List<List<Integer>> result, int start, LinkedList<Integer> current){
        if(start==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        //take the number
        findSubSetsOfLength(nums, result, start+1, current);
        current.addLast(nums[start]);
        findSubSetsOfLength(nums, result, start+1, current);
        current.removeLast();

    }
    
//     public void findSubSetsOfLength1(int nums[], List<List<Integer>> result, int start, int max, LinkedList<Integer> current){
        
//         if(current.size()==max){
//             result.add(new ArrayList<>(current));
//             return;
//         }
        
//         for(int i=start; i< nums.length;i++) {
//             current.addLast(nums[i]);
//             findSubSetsOfLength(nums,  result, i+1, max, current);
//             current.removeLast();
//         }
        
        
    // }
}