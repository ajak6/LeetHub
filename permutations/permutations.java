class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //duplicates?
        //Total permutations will be below Integer.MAX? and will fit in memory?
        // n! complexity to select
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result, new LinkedList<>(), new boolean[nums.length]);
        
        return result;
    }
    
    public void permute(int [] num, int k, List<List<Integer>> result, LinkedList<Integer> current, boolean visited[]){
        if(current.size() == num.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i=0; i < num.length; i++){
            if(visited[i]) continue;
            
            visited[i]=true;
            current.add(num[i]);
            permute(num, i, result, current, visited);
            current.removeLast();
            visited[i]=false;
            
        }
        
    }
}