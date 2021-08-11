class Solution {
    public int minFlips(int a, int b, int c) {
        
        
        // find the bit at a location
        int count=0;
        for(int i=0; i < 31;i++){
            int shift = 1<<i;  
            // System.out.println("Shift "+shift);
            int bitA = a & shift;
            int bitB = b & shift;
            int bitC = c & shift;
            // System.out.println(bitA + " " + bitB + " "+ bitC);
            if(bitC==0){
                if((bitA>>>i)==1)   count++;
                if((bitB>>>i)==1)   count++;
            }else{
                if((bitA|bitB)==0){
                    count++;
                }
            }
        }
        return count;
    }
}