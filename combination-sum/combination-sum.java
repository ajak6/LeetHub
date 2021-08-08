class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, result, new LinkedList<>());
        return result;
    }
    
    public void backtrack(int c[], int target, int i, int curr, List<List<Integer>> result, LinkedList<Integer> current){
        
        if(curr==target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(i==c.length)return;
        if(curr> target)return;
        
        for(int x= i; x< c.length;x++){
            if(x+1<c.length && c[x]==c[x+1])continue;
            if(curr + c[x]>target)return;
            current.add(c[x]);
            backtrack(c, target, x, curr + c[x], result, current);    
            current.removeLast();
        }
        
    }
    
}