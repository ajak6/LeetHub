class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // at moost k characters.
        // 2 pointer.
        // increase r, add to set
        // if set size >k count the lenfth r-l
        // keep increasing R and removing the count of chars from Map
        // when the size is below
        // or we store te latest index of char at l and move l 1 that index. but then we have to create a new set as well rmeov all chars between l and r 
        // 
        // Map of char and last index
        // we have to clean up the set as well so we can't just remove hte chars/
        int l=0;
        int r=0;
        if(k==0|| s==null || s.isEmpty())return 0;
        //store last index of character
        Map<Character,Integer> map = new HashMap<>();
        // map.put(s.charAt(0),0);
        int max = 0;
        char ch[] = s.toCharArray();
        while(r <= s.length()) {
            if(r<s.length()){
                map.put(s.charAt(r), r);
                r++;
            }
            if(map.size()<=k) {
                max = Math.max(r-l, max);
            }
            if(map.size()>k) {
                char atL = s.charAt(l);     
                //since anything we remove starts at l, atleast this characters needs to go
                // but we also need toremove all chars lower than its index in the map.
                //also keep doing until the isze of the map < k
                 //you have to pick just 1 char and remove it and remove few more that were in the way. so iterator over K dist in amp vs the string which could be higher.
                int upto = map.get(atL); //charAT L last occurance is upto remove all chars before that
                //end up removeing more than needed characters.
                //find the min index stored and move l to that min+1
                // map.entrySet().removeIf(entr-> entr.getValue()<= upto);
                int min = (int) map.values().stream().min(Comparator.naturalOrder()).get();
                map.remove(s.charAt(min));
                l = min+1;
            }
            if(r==s.length()) break;
            
        }
        return max;
        
        
        
    }
}