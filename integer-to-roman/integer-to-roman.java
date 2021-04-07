class Solution {
    TreeMap<Integer, String> main = new TreeMap<>();
    HashMap<Integer, String> sup = new HashMap<>();
    
    public Solution(){
        main.put(1, "I");
        main.put(5, "V");
        main.put(10, "X");
        main.put(50, "L");
        main.put(100, "C");
        main.put(500, "D");
        main.put(1000, "M");
        
        sup.put(4, "IV");
        sup.put(9, "IX");
        sup.put(40, "XL");
        sup.put(90, "XC");
        sup.put(400, "CD");
        sup.put(900, "CM");
    }
    
    public void getRoman(int n, StringBuilder builder){
     //800
        if(n<=0) return;
        if(main.containsKey(n)){
            //good we have a number 
            builder.append(main.get(n));
        } else if(sup.containsKey(n)){
            builder.append(sup.get(n));
        } else{
            Map.Entry<Integer, String> x = main.floorEntry(n);
            builder.append(x.getValue());
            getRoman(n-x.getKey(), builder);
            
        }
    }
    public String intToRoman(int num) {
        if(num ==0) return "";
        
        int div = 1000;
        StringBuilder builder =new StringBuilder();
        while(num>0 && div >0) {
            
            while(div>=num && div !=1){
                div=div/10;
            }
            int quotient=0;
            System.out.println("start newnum "+ num + " remainder "+ quotient + "  div "+ div);
            quotient = num/div;
            int prev=num;
            num  = num % div;
            quotient = prev-num;
            // num = num - remainder;
            div=div/10;
            
            getRoman(quotient, builder);
            System.out.println("End newnum "+ num + " remainder "+ quotient + "  div "+ div);
            
        } 
     return builder.toString();
    }
    
    
}