class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        //pick one number and find all numbers that sum to required number. Since we hav eto return index we cannot sort.
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, result, 0, new LinkedList<>());
        
        return new ArrayList<>(result);
    }
    
    //memoization should work, if we know 7,8 has not lead to any answers then it won't make sense to processed in any subtree
    // also can be avoid duplicates?
    HashMap<String, Integer>map = new HashMap<>();
    
    public void dfs(int c[], int start , int target, Set<List<Integer>> result, int curr, LinkedList<Integer> currIndexes){
        String s = start+":"+curr;
        if(map.containsKey(s) && map.get(s) == -1)return;
        if (curr==target) {
            result.add(new ArrayList<>(currIndexes));
            return;
        }
        
        if(start>=c.length || curr>target) {
            map.put(start+":"+curr, -1);
            return;
        }
            
        
        if(curr+ c[start] <= target){
            currIndexes.add(c[start]);
            dfs(c, start+1, target, result, curr+ c[start], currIndexes);        
            currIndexes.removeLast();        
        }
        while(start<c.length -1 && c[start]==c[start+ 1]) start++;
        dfs(c, start+1, target, result, curr, currIndexes);        
        
        
        
        // while(start>0 && c[start-1]==c[start]) start++;
        
        

    }
}