class Solution {
    public String reverseOnlyLetters(String s) {
        int l =0;
        int r= s.length()-1;
        char c []= s.toCharArray();
        while(l<r){
            char lChar = s.charAt(l);
            char rChar = s.charAt(r);
            if(Character.isLetter(lChar) && Character.isLetter(rChar)){
                c[l]=rChar;
                c[r]=lChar;
                l++;r--;
            }else if(!Character.isLetter(lChar)){
                l++;
            }else{
                r--;
            }
        }
        return new String(c);
    }
}