class Solution {
    public boolean containsDuplicate(int[] nums) {
        //use hashset
        // takes o(n) space
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
          if(!set.add(num))return true;  
        } 
        return false;
    }
}