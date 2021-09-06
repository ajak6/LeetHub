class Group {
    int start;
    int end;
    char c;
    int len;
    public Group(int s, int e, char c){
        start =s;
        end = e;
        this.c=c;
        len = e - s +1;
    }
    public String toString(){
        return c + " "+ start + " " + end + " " + len;
    }
}
class Solution {
    
    public int maxRepOpt1(String text) {
        //total char count
        // length of current continous substring
        int c[] = new int[26];
        int start =0;
        List<Group> list = new ArrayList<>();
        for(int i =0; i < text.length(); i++) { 
            c[text.charAt(i) - 'a']++;
            if (text.charAt(i) != text.charAt(start)) {
                list.add(new Group(start, i-1, text.charAt(start)));
                start = i;
            }
            
        }
        list.add(new Group(start, text.length()-1, text.charAt(text.length()-1)));
        int max = 0;
        for (int i=0; i < list.size(); i++) {
            Group p = list.get(i);
            int len = p.len;
            System.out.println(p);
            if(p.len < c[p.c - 'a']) {
                len++;
            }
            max = Math.max(max, len);
        }
        // System.out.println(max);
        
        for(int i = 1 ; i < list.size() - 1; i++) {
            Group g = list.get(i);
            if (g.len==1) {
                Group left = list.get(i-1);
                Group right = list.get(i+1);
                if(left.c == right.c) {
                    int lenExtra = c[left.c-'a'] > (right.len + left.len)?1:0;
                    max=Math.max(max, right.len + left.len + lenExtra);
                }
            }
        }
        
        return max;
    
    
    }
}