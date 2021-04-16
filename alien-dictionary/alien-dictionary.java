class Solution {
    /**
    Cases mised
    1. when first string is larger and second is a prefox of first in that case we cannot determine the order
    1. Above will hold true for same strings: for equalss order can be anything.
    1. When there is only 1 string then you return anyorder
    1. When there are extra characters in second string they will never be traversed if you break as soon as tere is a difference e.g. abc and abcd, d can be anywhere in this case but it will not be in set of keys/
    
    */
    public String alienOrder(String[] words) {
        // we can create a graph of edges when we ffind a character before other v->w means v comes before w.
        //at the end we need to do a top sort?
        //if there is a cuycle in top sortt return false.
        Map<Character, Set<Character>> map  = new HashMap<>();
        Map<Character, Integer> incoming = new HashMap<>();
        for(int i =0; i < words.length ; i++){
            
            
            String word1 = words[i];
            int a=0;
            while (a < word1.length()) {
                        map.putIfAbsent(word1.charAt(a), new HashSet<>());
                        incoming.putIfAbsent(word1.charAt(a),0);
                    a++;
            }
            
            for(int j = i+1; j < words.length ; j++) {
                String word2 = words[j];
                int b=0;
                if(!word1.equals(word2) && word1.startsWith(word2)) return "";
                while(b < word2.length()){
                        char charb=word2.charAt(b);
                        System.out.println("charb "+charb);
                        map.putIfAbsent(word2.charAt(b), new HashSet<>());    
                        incoming.putIfAbsent(charb , 0);
                        b++;   
                    }
                
                a=0; b=0;
                //special case when b is prefix of a we cannot find a relation.
                
                
                while(a < word1.length() || b < word2.length()) {
                    
                    
                    if(a < word1.length() && b < word2.length() && word1.charAt(a) != word2.charAt(b)) {
                        if(map.get(word1.charAt(a)).add(word2.charAt(b))) {
                        //if an edge already exists I don't want to count it twice in incoming.
                            incoming.merge(word2.charAt(b), 1, Integer::sum);
                        }
                        break;
                    }
                    
                    
                    a++;b++;
                    
                    
                }
                
            }
        }
        System.out.println(incoming);
        //top sort of this graph.
        StringBuilder builder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        incoming.entrySet().stream().filter(x-> x.getValue()==0).forEach(e1-> queue.offer(e1.getKey()));
        System.out.println(map);
        while(!queue.isEmpty()){
            
            char c = queue.poll();
            builder.append(c);
            Set<Character> endIndex = map.get(c);
            for (char cc: endIndex) {
                incoming.merge(cc, -1, Integer::sum);
                if(incoming.get(cc)==0){
                    queue.offer(cc);
                }
            }
        }
        // return builder.toString();
        return builder.length() == incoming.size()? builder.toString(): "";
        // return "cabd";
    }
}