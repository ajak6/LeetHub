class Solution {
    class Pair{
        char c;
        int count;
        public Pair(char _c, int _count) {
            c=_c;
            count = _count;
        }
        public String toString(){
           return "task :"+c + "  "+ count; 
        }
    }
    
    public String rearrangeString(String s, int n) {
        
        char tasks []=s.toCharArray();
            
        int [] counts = new int[26];
        for(char task : tasks) {
            counts[task - 'a']++;
        }
        //we create a max heap which gives chars with heightest count left.
        //since we need to add a gap of n if we get an element from the heap we will have to keep
        //this one in reserve until we have used up n tasks.
        //what we create an queue like structure where we put an element 
    //keep a count if how many tasks we have included and pull the task in the array at position 
        //currnt eleemtn selected count - n : if it is still eleibilihge with heighest count we will select it
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparing(x-> -x.count));
        
        for(int i=0;i < counts.length; i++) {
            if(counts[i]>0){
                maxHeap.offer(new Pair((char)(i+'a'), counts[i]));
            }
            
        }
        Map<Character, Integer> lastIndex = new HashMap<>();
        Map<Character, Pair> charToPair = new HashMap<>();
        List<Character> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int currentIndex =0;
        int totalCharsIncluded =0;
        while(true) {
            // System.out.println(lastIndex);
            // System.out.println(charToPair);
            //figuree out if any element can be reincluded now?
            if(lastIndex.size()>0 && currentIndex > 0) {
                int minIndex =Integer.MAX_VALUE;
                HashSet<Character> toRemove = new HashSet<>();
                for(Map.Entry<Character, Integer> entry: lastIndex.entrySet()){
                    if( currentIndex - entry.getValue() >= n) {
                        maxHeap.offer(charToPair.get(entry.getKey()));
                        toRemove.add(entry.getKey());
                    }
                    minIndex=Math.min(minIndex, entry.getValue());
                }
                toRemove.stream().forEach(x-> lastIndex.remove(x));
                
//                 if(maxHeap.isEmpty()) {
//                 //you need to add some blanks now/
//                     while(currentIndex - minIndex <= n){
//                         result.add(' ');
//                         builder.append(".");
//                         currentIndex++;
//                     }  
//                     toRemove = new HashSet<>();
//                     for(Map.Entry<Character, Integer> entry: lastIndex.entrySet()){
//                         if(currentIndex - entry.getValue() >= n) {
//                             maxHeap.offer(charToPair.get(entry.getKey()));
//                             toRemove.add(entry.getKey());
//                         }
                        
//                     }
//                     toRemove.stream().forEach(x-> lastIndex.remove(x));
//                     System.out.println(builder.toString());
//                     return "";
//                 }   
            }
            // System.out.println("result "+ result);
            //how to add blanks?
            //lets say queue is still empty
            if(maxHeap.isEmpty()) break;
            Pair p=maxHeap.poll();
            result.add(p.c);
            builder.append(p.c);
            p.count--;
            if(p.count>0){
                charToPair.put(p.c, p);
                lastIndex.put(p.c, currentIndex);    
            }
            
            currentIndex++;
        }
        // System.out.println(result);
        return builder.length()==s.length() ? builder.toString() :"";
    
        
    }
}