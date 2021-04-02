class Solution {
    public boolean isSubsequence(String s, String t) {
        
        //brute force
        //pick the smaller string and find it in bugger string
        // char c in s find it in t once found find the rest in t.sub
        //if all foun,d then return true;
        int j=0;
        //this looks like greedy approach.
        //linear time for search
        // for(int i=0;i< s.length();i++){
        //     char ss = s.charAt(i);
        //     boolean found = false;
        //     for(;j< t.length();j++) {
        //         if(t.charAt(j)==ss) {
        //             found = true;
        //             j++;
        //             break;
        //         }
        //     }
        //     if(!found) return false;
        // }
        // return true;
        
        
        
        List[] chars= new List[256]; //1 list per character
        for(int i=0 ; i< t.length(); i++){
            if(chars[t.charAt(i)-'a']==null){
                chars[t.charAt(i) - 'a'] = new ArrayList<Integer>();
            }
            chars[t.charAt(i)-'a'].add(i);
        }
        // System.out.println(Arrays.toString(chars));
        int prev =0;
        for(int i=0;i<s.length(); i++) {
            char toSearch = s.charAt(i);
            List<Integer> indexes = chars[toSearch -'a'];
            if(indexes==null) return false;
            System.out.println(" char "+ toSearch + "  its indexes "+ indexes + " search for "+ prev);
            int foundAt = Collections.binarySearch(indexes, prev);
            System.out.println("found at"  + foundAt);
            // if it is not found you will geet a negative number
            if(foundAt < 0) foundAt = -foundAt-1;
            if(foundAt == indexes.size()){
//             this means that all the indedxes where our caracters are present are smaller than what we are loooking for. This is why the actual insertion point is at the ned.
                //so a point which is after the last element in the array menas we cannot find the subsequency.
                return false;
            }
            int actualIndexInT = indexes.get(foundAt);
            System.out.println("actual index in array at " + actualIndexInT + "prev is "+ prev);
            // if(foundAt ==indexes.size())  return false; //it means we don't have this character in the t string
            if(prev > actualIndexInT) return false;
            prev= actualIndexInT+1;
        }
        
        // return search(s, 0, t , 0);
        return true;
    }
    
    //This is me being stupid and writing the slowest algorithm possible.
    
    public boolean search(String s, int i, String t, int j){
        if(i == s.length()) return true;
        char search = s.charAt(i);
        
        for(int x=j; x< t.length(); x++) {
            if(t.charAt(x)==search){
                if(search(s, i+1, t, x+1)) {
                    return true;
                }
            }
           
        }
        return false;
    }
}