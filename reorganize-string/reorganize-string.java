class Solution {
    public String reorganizeString(String S) {
     
        
        //need to be greedy to avoid conflicts 
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y) -> Integer.compare(y[1], x[1]));
        int count[]= new int[26];
        for(int i =0; i < S.length(); i++){
            count[S.charAt(i)-'a']++;
        }
        
        for(int i =0; i < count.length; i++) {
            if(count[i]>0)
            maxHeap.offer(new int[]{i+'a', count[i]});
        }
        
        int prev[] = null;
        StringBuilder builder = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            int[] temp = maxHeap.poll();
            
            builder.append((char)temp[0]);
            temp[1]--;
            if(prev!=null){
                if(prev[0]==temp[0]) return "";
                if(prev[1]>0)            
                    maxHeap.offer(prev);
            }
            prev = temp;
        }
       // System.out.println("builder "+builder.toString());
        return builder.length() == S.length()? builder.toString():"";
    }
                                  
                                  
        
        //find out which characters are together?
        //or using all characters create a string in which no chars are repeated
        /*
        a-2
        b-1
        create string 
        a - 1 - reduce count
        b - 1 - reduce count
        a - 1 - reduce count. 
        total count is zero
        */
        
        
        
//         char prev='z';
//         HashMap<Character, Integer> freqCount = new HashMap<>();
//         for(char c: S.toCharArray()) {
//             freqCount.merge(c, 1, Integer::sum);
//         }
        
//         PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.val - p1.val);
        
//         for(Map.Entry<Character,Integer> entry: freqCount.entrySet()){
//             maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
//         }
        
//         StringBuilder builder = new StringBuilder();
//         //sort ick the highestfrequenc first and create array
//         // sort by frequency
//         // Heap 
//         Pair entryPrev = null;
//         // System.out.println("maxheap  :" +maxHeap);
//         while( maxHeap.size() > 0 ) {
//             // System.out.println("maxheap  :" +maxHeap);
//             Pair curr= maxHeap.poll();
//             // System.out.println("Curr is "+ curr.key);
//             builder.append(curr.key);
//             if(entryPrev !=null && entryPrev.key == curr.key){
//                 return "";
//             }
//             if(entryPrev != null && entryPrev.val>0) {
//                 maxHeap.offer(entryPrev);
//             }
//             entryPrev  = new Pair(curr.key, curr.val-1);
            
//         }
//         // if(entryPrev!=null && entryPrev.val >0) return "";//this means we have not included something 
//         String result = builder.toString();
//         return result.length() == S.length()? result: "";    
        
    // }
}
class Pair{
    public char key;
    public int val;
    public Pair(char c, int v){
        key=c;
        val=v;
    }
    public int getValue(){
        return val;
    }
    public String toString(){
        return key + " : "+ val;
    }
}
                                                                              
                                                                              