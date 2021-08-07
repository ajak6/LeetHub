class Solution {
    public int romanToInt(String s) {
        /*
        if you see I then check next char if that is V then its 4 and if it is X then its 9
        if you see X and next is L then it is 40 and C means 90
        if you C and next is D the n1000 and M makes 900
        CD 500
        CM 900
        IV 4
        IX 9
        XL 40
        XC 90
        C 100
        D 500
        M 1000
        I 1
        V 5
        */ 
        // you need to check 1 char or 2
        // MCMXCIV
        // 1000 + 900 + 90 + 4
        HashSet<Character> set  = new HashSet<>();
        set.add('C'); set.add('I');set.add('X');
        HashMap<String, Integer> map = new HashMap<>(){{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};
        HashMap<String, Integer> special = new HashMap<>(){{
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
            put("IX", 9);
            put("IV", 4);
        }};
        int index = 0;
        int sum = 0;
        while (index < s.length()) {
            char cc = s.charAt(index);
            index++;
            
            if(index<s.length() && set.contains(cc)) {
                char cc2 = s.charAt(index);
                if(special.containsKey(""+cc+cc2)) {
                    sum+=special.get(""+cc+cc2);
                    index++;
                } else {
                    sum += map.get(""+cc);
                }
            } else {
                sum += map.get(cc+"");
            }
        }
        
        return sum;
    }
}