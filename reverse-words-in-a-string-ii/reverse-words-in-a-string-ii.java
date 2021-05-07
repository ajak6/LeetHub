class Solution {
    public void reverseWords(char[] s) {
      int i=0;
        int j=s.length-1;
        
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;j--;
        }
        int l=0;
        int r=0;
        while(r<s.length){
            if(s[r]!=' '){
                r++;
            }else{
                reverse(s,l,r-1);
                l=++r;
            }
        }
        reverse(s,l,r-1);
    }
    
    public void reverse(char c[], int start, int end){
        while(start< end) {
            char x = c[start];
            c[start]=c[end];
            c[end]=x;
            start++;
            end--;
        }
    }
}