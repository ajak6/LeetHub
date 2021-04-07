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
    
    
    public String rearrangeString(String str, int k){
        
        char c[] = str.toCharArray();
        
        StringBuilder builder = new StringBuilder();
        int i=0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparing(x-> -x[1]));
        int count[] = new int[26];
        while(i < c.length){
            count[c[i]-'a']++;
            i++;
        }
        System.out.println(Arrays.toString(count));
        for(i=0; i < count.length ; i++){
            if(count[i]>0){
                // System.out.println("offer "+ (i+'a') + " count " + count[i]);
                maxHeap.offer(new int[]{i+'a', count[i]});
            }
        }
        Queue<int[]> backlog = new LinkedList<>();
        while(!maxHeap.isEmpty()){
            
            int curr [] = maxHeap.poll();
            // System.out.println("Curr "+ Arrays.toString(curr));
            if(curr[1]==0) break; // the top element is finished means we are  done.//in case it is not possible then what?
            
            builder.append((char)curr[0]);
            curr[1]--;
            if(curr[1]>=0){
                //we now have to wait k cucles before using it again.
                //to keep the backlog size same push with zeros.
                backlog.offer(curr);
                //push it in a stack may be no queue we need this first out.
            }
            //taking out elements.
            //we want to add blanks then we gave to do it here.
            
            // When we are starting our queue wil be smaller so don't pull anything from the queue.
            if(backlog.size() < k) continue;
            
            int cx[] = backlog.poll();
            maxHeap.offer(cx);
            
        }
        return builder.toString().length() == str.length()? builder.toString(): "";
    }
    public String rearrangeString1(String str, int k){
         
        StringBuilder rearranged = new StringBuilder();
        //count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        //construct a max heap using self-defined comparator, which holds all Map entries, Java is quite verbose
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });
        
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());
        
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap + " waitQueue "+waitQueue);    
            
            Map.Entry<Character, Integer> current = maxHeap.poll();
            rearranged.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQueue.offer(current);
            
            if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
                continue;
            }
            // release from waitQueue if char is already k apart
            Map.Entry<Character, Integer> front = waitQueue.poll();
            //note that char with 0 count still needs to be placed in waitQueue as a place holder
            if (front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }
        
        return rearranged.length() == str.length() ? rearranged.toString() : "";
    }
    public String rearrangeString12(String s, int n) {
        
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
        Queue<Pair> waitQueue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        int currentIndex =0;
        int totalCharsIncluded =0;
        while(true) {
            // System.out.println(lastIndex);
            // System.out.println(charToPair);
            //figuree out if any element can be reincluded now?
            // if(lastIndex.size()>0 && currentIndex > 0) {
            //     int minIndex =Integer.MAX_VALUE;
            //     HashSet<Character> toRemove = new HashSet<>();
            //     //we only need 1 at a time. If the char with least index used is picked up using another heap
            //     //it should wkr faster instead of looping throught the array
            //     for(Map.Entry<Character, Integer> entry: lastIndex.entrySet()){
            //         if( currentIndex - entry.getValue() >= n) {
            //             maxHeap.offer(charToPair.get(entry.getKey()));
            //             toRemove.add(entry.getKey());
            //             break;
            //         }
            //         minIndex=Math.min(minIndex, entry.getValue());
            //     }
            //     toRemove.stream().forEach(x-> lastIndex.remove(x));
                
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
            // }
            // System.out.println("result "+ result);
            //how to add blanks?
            //lets say queue is still empty
            if(maxHeap.isEmpty()) break;
            // System.out.println(maxHeap);
            // System.out.println("waitqueue " + waitQueue);
            Pair p=maxHeap.poll();
            result.add(p.c);
            builder.append(p.c);
            p.count--;
            waitQueue.offer(p);
            
//             if(p.count>=0){
//                 // charToPair.put(p.c, p);
//                 // lastIndex.put(p.c, currentIndex);    
                
//                 waitQueue.offer(p);
//             }
            if(waitQueue.size() < n) continue;
            Pair waiting = waitQueue.poll();
            if(waiting.count >0)
                maxHeap.offer(waiting);
            currentIndex++;
        } 
        // System.out.println(result);
        return builder.length()==s.length() ? builder.toString() :"";
//      while (!maxHeap.isEmpty()) {
            
//             Map.Entry<Character, Integer> current = maxHeap.poll();
//             rearranged.append(current.getKey());
//             current.setValue(current.getValue() - 1);
//             waitQueue.offer(current);
            
//             if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
//                 continue;
//             }
//             // release from waitQueue if char is already k apart
//             Map.Entry<Character, Integer> front = waitQueue.poll();
//             //note that char with 0 count still needs to be placed in waitQueue as a place holder
//             if (front.getValue() > 0) {
//                 maxHeap.offer(front);
//             }
//         }
        
    }
}

