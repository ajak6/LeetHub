class Solution {
    
//     public static int romanToInt(String s) {
        
        
//         // read the string
//         // IVIII
//         // We know mappings of e ach char to  number
//         // hit I change to 1 and ass to result
//         // hit II change to 1 and add to result
//         // if you hit I then chenc the next char as well: wait for 3 special chars if you see them check next char as well
//         //other wise you keepgetting its value add adding to the result
//         // problem is 
//         Map<String, Integer> special = new HashMap<>(){{
//             put("IV", 4);
//             put("IX", 9);
//             put("XL", 40);
//             put("XC", 90);
//             put("CD", 400);
//             put("CM", 900);
//         }};
//          HashMap<Character, Integer> values = new HashMap<>(){{
//             put('I', 1);
//             put('V', 5);
//             put('X', 10);
//             put('L', 50);
//             put('C', 100);
//             put('D', 500);
//             put('M', 1000);
//         }};
//         int sum =0;
//         for(int i=s.length() -1; i >=0; i--) {
//             //IV
//             // if the last one used in the left is small;e than current then we will have special case
//             char c= s.charAt(i);
//             if(i<s.length()-1 && values.get(s.charAt(i+1)) > values.get(c)){
//                 sum-= values.get(c);
//             }else{
//                 sum += values.get(c);
//             }
        
        
//         }
//         return sum;
//     }
// }

    /*
     * Complete the function below.
     */
    static int romanToInt(String romanNumeral) {
        
        // VIII -> 5 + 1+ 1+ 1 -> result = 8
        // IVX -> 4 X 10 -> 14 -> INCORRECT case
        // X IV -> 10 + 1 + 5 -> 
        // IV IX -> 
        // XIV -> 10 + 1 + 5 - 2*1 -> 14 -> 
        // X L  -> 10 + 50 - 20-> 40
        
        //invalid input: V I X - 5 + 1 + 10 -2 -> 14
        
        if(romanNumeral==null || romanNumeral.isEmpty())return 0;
        
        int result =0; //might overflow
        char[] romanArr= romanNumeral.toCharArray();
        for(int i=0; i < romanNumeral.length(); i++){
            char currentChar = romanArr[i];
            result += getVal(currentChar);
            if(i>0 && checkSmallerAndValid(romanArr[i-1], currentChar)) {
                result -= 2 * getVal(romanArr[i-1]);
            }
        }
        
        return result;
    }
    
    
    public static void validate(char c[]) {
        Map<Character, Integer> pos = new HashMap<>();
        Map<Character, Integer> validPos = new HashMap<>(){{
            
        }};
        
        for(int i=0; i < c.length; i++){
            for(int j=i-2; j>=0; j--){
                // if()
            }
            pos.put(c[i],i);
            
        }
    }
    public static boolean checkSmallerAndValid(char prev, char current){
        String combo = "" + prev+current; // search a better way
          return combo.equals("IV") || combo.equals("IX") || combo.equals("XL") || combo.equals("XC") || combo.equals("CD") || combo.equals("CM");
    }
    
    public static int getVal(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException( " Unsupported roman char", null);
        }
    }
}

//             char c = s.charAt(i);
//             //may be chekc the next chars first else move on to add the correct mappings
//             if("IXC".contains(c+"") && i < s.length()-1) {
//                 String sp = ""+ c + s.charAt(i+1);
//                 if(special.containsKey(sp)) {
//                     sum += special.get(sp);
//                     i++;
//                 } else{
//                     sum += values.get(c);
//                 }
//             } else{
//                 sum += values.get(c);
//             }
                   
        // }
        // return sum;
        
    // }
    
//     public static int romanToInt(String s) {
// 	if (s == null || s.length() == 0)
// 		return -1;
// 	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
// 	map.put('I', 1);
// 	map.put('V', 5);
// 	map.put('X', 10);
// 	map.put('L', 50);
// 	map.put('C', 100);
// 	map.put('D', 500);
// 	map.put('M', 1000);
// 	int len = s.length(), result = map.get(s.charAt(len - 1));
// 	for (int i = len - 2; i >= 0; i--) {
// 		if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
// 			result += map.get(s.charAt(i));
// 		else
// 			result -= map.get(s.charAt(i));
// 	}
// 	return result;
//     }
//     public int romanToInt2(String s) {
//         /*
//         if you see I then check next char if that is V then its 4 and if it is X then its 9
//         if you see X and next is L then it is 40 and C means 90
//         if you C and next is D the n1000 and M makes 900
//         CD 500
//         CM 900
//         IV 4
//         IX 9
//         XL 40
//         XC 90
//         C 100
//         D 500
//         M 1000
//         I 1
//         V 5
//         */ 
//         // you need to check 1 char or 2
//         // MCMXCIV
//         // 1000 + 900 + 90 + 4
//         HashSet<Character> set  = new HashSet<>();
//         set.add('C'); set.add('I');set.add('X');
//         HashMap<String, Integer> map = new HashMap<>(){{
//             put("I", 1);
//             put("V", 5);
//             put("X", 10);
//             put("L", 50);
//             put("C", 100);
//             put("D", 500);
//             put("M", 1000);
//         }};
//         HashMap<String, Integer> special = new HashMap<>(){{
//             put("XL", 40);
//             put("XC", 90);
//             put("CD", 400);
//             put("CM", 900);
//             put("IX", 9);
//             put("IV", 4);
//         }};
//         int index = 0;
//         int sum = 0;
//         while (index < s.length()) {
//             char cc = s.charAt(index);
//             index++;
//             char cc2='\u0000';
//             if(index<s.length()) {
//                 cc2 = s.charAt(index);
//             }
//             String substr = ""+cc+cc2;
//             if(special.containsKey(substr)) {
//                 sum+=special.get(substr);
//                 index++;
    
//             } else {
                
//                 sum += map.get(cc+"");
//             }
//         }
        
//         return sum;
//     }
    
    
// }