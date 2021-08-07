class Solution {
    public boolean isPalindrome(int x) {
       //create  the reverse number
        int sum =0;
        if(x<0)return false;
        int original = x;
        while(x>0){
            //121
            int last = x % 10; 
            sum = sum * 10 + last; // 30+2=320+1=321
            x = x / 10; //121/10 = 12
        }
        // System.out.println(sum);
        
        return sum == original;
    }
}