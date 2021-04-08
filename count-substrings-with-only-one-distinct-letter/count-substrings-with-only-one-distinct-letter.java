class Solution {
    public int countLetters(String S) {
        //count distinct characters.
        int repeat=1;
        char prev = S.charAt(0);
        int total =0;
        for(int i=1; i < S.length(); i++){
            
            char c = S.charAt(i);
            if(prev!=c) {
                total+=getCount(repeat);
                prev=c;
                repeat=1;
            } else {
                repeat++;
            }
        }
        System.out.println(repeat);
        //last streak will not endthis way
        total+=getCount(repeat);
        return total;
    }
    public int getCount(int n) {
        return (n*((n+1))/2);
    }
}