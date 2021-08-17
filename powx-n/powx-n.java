class Solution {
    public double myPow(double x, int n) {
        
        return myPow(x, Long.valueOf(n));
    }
    
    public double myPow(double x, long n){
        if(n==0)return 1.0;
        //if you are converting a negative number to positive always keep in mind it will fail for boundary values with out of range.
        if(n<0) {
            return myPow(1/x, -n);
        }
        if(n==1){
            return x;
        }
        if(n==2){
            return x*x;
        }
        
        double res = myPow(x, n/2);
        if((n & 1) == 0){ //even power
            return res*res;    
        }else{
            return res*res*x;
        }
    }
}