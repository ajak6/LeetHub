class Solution {
    public String addStrings(String num1, String num2) {
        // start from the end
        //jkeep summing if we have value 
        // add carre
        // at the end append to string buildrer
        //reverse the bvuidling and return result
        // static array will be hard
        
        StringBuilder builder = new StringBuilder();
        int n1=num1.length()-1;
        int n2=num2.length()-1;
        int carry =0;
        while(n1>=0 || n2>=0 || carry >0){
            char val1='0';
            char val2= '0';
            if(n1>=0) {
                val1=num1.charAt(n1);
                n1--;
            }
            if(n2>=0) {
                val2= num2.charAt(n2);
                n2--;
            }
            int sum = Character.getNumericValue(val1) + Character.getNumericValue(val2) + carry;
            System.out.println( Character.getNumericValue(val1));
            
            carry=sum/10;
            sum=sum%10;
            builder.append(sum);
        }
        
        return builder.reverse().toString();
        
    }
}