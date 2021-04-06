class Solution {
    Map<String, Character> map ;
    public int numDecodings(String s) {
       // number of way to decoe the string
        // ways to decode the string.//you sartfrom left an pick 1 and 2 char at a time.
        //and ecode the rest of the string.
        //if you are able to decode it you return
        // ways(s[1:]) + ways(s[2+])
        map = new HashMap<>();
        for(char c='A'; c<='Z' ; c++){
            int key  = c-'A'+1;
            map.put(String.valueOf(key), c);
        }
        return ways(s);
    }
    HashMap<String , Integer> memo = new HashMap<>(); 
    public int ways(String s) {
        if(s.isEmpty()) return 1;
        if(memo.containsKey(s)) return memo.get(s);
        String s1 = s.substring(0,1);
        String s2 = "";
        if(s.length()>1)
            s2 = s.substring(0,2);
        int count =0;
        if(map.containsKey(s1)) {
            count+=ways(s.substring(1));
        }
        if(map.containsKey(s2)){
            count+=ways(s.substring(2));
        }
        memo.put(s, count);
        return count;
        
    }
}