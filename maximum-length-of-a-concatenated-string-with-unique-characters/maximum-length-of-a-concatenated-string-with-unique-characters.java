class Solution {
    public int maxLength(List<String> arr) {
         // concat only those where the resulting string has unique characters
        //space time?
        // does the order matter? esults in a diff string so yes
        // so nay pair we din will generte 2un iq and iqun you can count but the length won;t change
        //brute force
        //1. pick a string loop over all strings nad loop over both string to find if any character matches - can be done by using a char array of int 128 and see if it collides- takes n time (length of secod setring tgetting )
        //2 or we can create a bitmask of every string. 
        //then we just do a or of 2 string as see if its 1 we count the length
        //bitmask can save the comparision
        //still takes n2 time.
        int max =0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int maxCount=0;
        for(int i=0; i < arr.size(); i++) {
            // for event strins if it unique iwht previous you take it or not take it so that ther can a longestr string can attach.
            // int biti=getBit(arr.get(i));
            int biti =0;
            //also count if there are dupllicates in the same string.
            boolean dup=false;
            for(char c: arr.get(i).toCharArray()) {
                int x = 1 <<  (c-'a');
                dup = (biti & x) > 1;
                if(dup)break;
                biti = biti | x ;
            }
            if(dup) {
                continue;
            }
            
                //this string is unique lets combine it with all previous strings if allowed.
                
            for (int j = list.size()-1; j>=0;j--) {
                
                if( (list.get(j) & biti ) == 0) {
                    
                    list.add(list.get(j) | biti);
                    maxCount = Math.max(maxCount, Integer.bitCount(list.get(j)| biti));
                }
            }
            
            // maxCount = Math.max(maxCount, Integer.bitCount( biti));
            // list.add(biti);
        }
        
        return maxCount; 
    }
    //    public int maxLength(List<String> A) {
    //     List<Integer> dp = new ArrayList<>();
    //     dp.add(0);
    //     int res = 0;
    //     for (String s : A) {
    //         int a = 0, dup = 0;
    //         for (char c : s.toCharArray()) {
    //             dup |= a & (1 << (c - 'a'));
    //             a |= 1 << (c - 'a');
    //         }
    //         if (dup > 0) continue;
    //         for (int i = dp.size() - 1; i >= 0; --i) {
    //             if ((dp.get(i) & a) > 0) continue;
    //             dp.add(dp.get(i) | a);
    //             res = Math.max(res, Integer.bitCount(dp.get(i) | a));
    //         }
    //     }
    //     return res;
    // }
    public int getBit(String s){
        
        int but =0;
        for(int i=0;i<s.length() ;i++){
            but|=(1<< (s.charAt(i) - 'a'));
        }
        return but;
        
    }
}