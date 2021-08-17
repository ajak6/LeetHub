class Solution {
    public int countSubstrings(String s) {
        
        // FROM THE STRING FIND THE SUBSTRING WHICH ARE PALINDROME
        // IF WE DESIGN A N/N MATRIX AND STORE THE ROW AS START INDEX AND COL AS END INDEX
        // WE CAN COUNT HOW MANY ROW,COL GIVE US TRUE FOR PALINDROMES AND THAT WILL BE OUR ANSWER
        // OR WE CREATE ALL SUBSTRING AND CHECK IF THEY ARE PALINDROMES
        // n*n+1/2 is the number of substring possible IS THE BUMBER OF SIBSTRINGS
        // CHECKING
        //ABCD - 4^2-> 16
        boolean dp [][] = new boolean[s.length()][s.length()];
        //cols will always start from row +1;
        // int len=1;
        int total =0;
        for(int len =0; len < s.length(); len++) {
            for(int row =0, col=0; col+len<s.length() && row < s.length(); row++, col++) {

                if(row==col+len)dp[row][col+len]=true;

                else {
                    dp[row][col+len]= s.charAt(row)==s.charAt(col+len);
                    if (row+1 < dp.length && col+len-1 >=0 && row+1<=col+len-1) {
                        dp[row][col+len]=dp[row][col+len] & dp[row+1][col + len -1];
                    }
                }
                if(dp[row][col+len]) total++;
            }
        }
        return total;
        
    }
}