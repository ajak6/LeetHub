class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        int max=0;
        String word1 = strs[0];
        out:
        for(int i=0; i < word1.length(); i++) {
            for (int j=1; j<strs.length;j++) {
                if(strs[j].length()<=i) break out;
                else if(strs[j].charAt(i)==word1.charAt(i)) {
                    continue;
                } else{
                  break out;
                }
            }
            max++;
        }
        return word1.substring(0, max);
    }
}