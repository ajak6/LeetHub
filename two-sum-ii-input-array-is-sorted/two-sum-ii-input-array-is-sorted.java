class Solution {
    public int[] twoSum(int[] n, int target) {
        
        int l = 0;
        int h = n.length-1;
        
        while(l<h){
            if(n[l]+n[h] == target) {
                return new int[]{l+1,h+1};
            } else if(n[l]+n[h] < target){
                l++;
            } else{
                h--;
            }
        }
        return new int[0];
        
    }
}