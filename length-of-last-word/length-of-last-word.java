class Solution {
    public int lengthOfLastWord(String s) {
        String ss[] = s.split("\\s+");
        if(ss.length > 0)
            return ss[ss.length-1].length();
        return 0;
    }
}