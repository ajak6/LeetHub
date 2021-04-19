class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.isBlank())return true;
        //word dict
        //you have dict in hashset
        //recursively you create a substruing if it is fgoun in the wordDict you recurse wth the left move string and see if recurison returns true
        //base condition is hwne you are end wupw ith an empty string.
        // System.out.println(s);
        if(map.containsKey(s)) return map.get(s);
        HashSet<String> set = new HashSet<>(wordDict);
        for(int i=1; i < s.length()+1; i++){
            
            if(set.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict)){
                map.put(s, true);
                return true;
            }
            
        }
        map.put(s, false);
       return false;
    }
    HashMap<String, Boolean> map = new HashMap<>();
    // on every call you need to find that a string can be normalized or not if we store the string result that should be enough
    
    
    
}