class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        ///check current substring and call with rest of the string
        return wb(s, new HashSet<>(wordDict));
    }
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean wb(String s, HashSet<String> wd) { 
        if(s.isBlank())return true;
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        for(int i=0; i < s.length(); i++){
            if(wd.contains(s.substring(0,i+1)) && wb(s.substring(i+1), wd)){
                map.put(s,true);
                return true;
            }
        }      
        map.put(s, false);
         return false;
    } 
}