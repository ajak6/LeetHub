class Solution {
    public int firstUniqChar(String s) {
        // find a first char which is unique in the string
        // traverse and remove if you see again??? more than 2 fails this 
        // count the occurence, at the end pick ones which are 1
        //we neeed the first eleemnt so hashmap will not not help unelss  I also sort it. by index
        // this is a lot of ocmputation  
        // Map of index and map of count.
        //puck the lowest count and them find its index and pick the lowest index
        
    //1 char find it in entire string n2 algorith
    //4$uMt2Wx
        Map<Character,Integer> charIndex=new HashMap<>();
        Map<Character,Integer> charCount = new HashMap<>();
        
        for(int i =0; i < s.length();i++) {    
            charIndex.putIfAbsent(s.charAt(i), i);
            charCount.merge(s.charAt(i), 1, Integer::sum);
        }
        List<Character> list = charCount.entrySet().stream().filter(e-> e.getValue()==1).map(e1-> e1.getKey()).collect(Collectors.toList());
        int min=s.length();        
        for(char c: list) {
            min=Math.min(min, charIndex.get(c));
        }
        return min==s.length()?-1:min;
               
    }
}