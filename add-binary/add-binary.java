class Solution {
    public String addBinary(String a, String b) {
        //can do normal sum taking 1 location at a time.
        //maintaining a carry when it is over 2 
        //when 
        
        //noi sign bits so basically
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder builder = new StringBuilder();
        int carry=0;
        while(i>=0 || j >=0){
            int val1= 0, val2=0;
            if (i>=0) val1 = Character.getNumericValue(a.charAt(i--)); 
            if(j>=0)  val2 = Character.getNumericValue(b.charAt(j--));
            
            int sum = (val1+ val2+ carry);
            carry = sum / 2;
            sum = sum % 2;
            builder.append(sum);
        }
        if(carry>0)builder.append(carry);
        return builder.reverse().toString();
    }
}