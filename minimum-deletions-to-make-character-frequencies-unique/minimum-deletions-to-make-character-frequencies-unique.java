class Solution {
    public int minDeletions(String s) {
        int freq [] = new int [26];
        
        for(char c : s.toCharArray()) {    
            freq[ c-'a' ]++;
        }
        int res =0;
        //since we only have 26 characters. count will also be different 26 numbers max: bnut cannoy be index like this
        //"aaabbbcc"
        //"bbcebab"
        Set<Integer> set = new HashSet<>();
        
        for( int i =0; i < freq.length; i++){
            int curr = freq[i];
            if(freq[i]==0)continue;
            while(set.contains(curr)){
                curr--;
                res++; 
            }
            if(curr!=0)
                set.add(curr);
            // find out the number 
        }
        return res;
    }
}