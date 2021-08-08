class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // total size of array shoudl be k
        //start from 1 and end at 9, only use the array elements once
        int c [] = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(c,k,n, new LinkedList<>(), result, 0, 0);
        return result;
    }
    
    public void backtrack(int c[], int size, int target, LinkedList<Integer>current, List<List<Integer>> result , int currSum, int start){
        
        if(currSum==target && current.size()==size){
            result.add(new ArrayList<>(current));
        }
        if(start > c.length){
            return;
        }
        if(currSum >= target)return;
        
        for(int i =start; i <c.length; i++){
            
            int newSum = currSum+ c[i];
            if(newSum>target)continue;
            current.add(c[i]);
            backtrack(c, size, target, current, result, newSum, i+1);
            current.removeLast();
        }
    }
    
}