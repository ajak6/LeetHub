class Solution {
    public List<String> restoreIpAddresses(String s) {
        ///brute force add a . to include upto 3 digit bnumbers less than 255. If the number gets higher than that skip creating next section.\
        // 255.5.5.5
        // 2.55.5.5
        // 25.5.5.5
        // 2.55.5.5
        // 2.5.55.5
        // 2.5.5.55
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), res, 1);
        return res;
        
    }
    
    public void backtrack(String s, int st, StringBuilder curr, List<String> res, int count){
        // System.out.println(curr);
        if(st==s.length() && count ==5){
            
            res.add(curr.toString());
            return;
        }
        if(count ==5 && st<s.length())return;
        if(st==s.length())return;
        //on every location you have 2 choices. Either add
        //on every call lets try to add all possible numbers and add . and recurse to do the same with remaining . for each possibility
        String section ="";
        if(s.charAt(st)=='0'){
            curr.append("0");
            if(count<4)
                    curr.append('.');
            backtrack(s, st+1, curr, res, count+1);
            
            if(count<4) {
                curr.setLength(curr.length()-2);
            }else{
                curr.setLength(curr.length()-1);
            }
            return;
        }else{
            for(int i=st; i < s.length() && i < st+3; i++){
            
                section += s.charAt(i);
                int number = Integer.parseInt(section);
                //in case of 0 we cannot use more than 1 zeros and add it as a single 0
                if(number>255) continue;
                curr.append(number);
                if(count<4)
                    curr.append('.');
                backtrack(s,i+1, curr, res, count+1);
                if(count<4) {
                    curr.setLength(curr.length()-(section.length() + 1));
                }else{
                    curr.setLength(curr.length()-(section.length()));    
                }
            }    
        }
        
    }
}