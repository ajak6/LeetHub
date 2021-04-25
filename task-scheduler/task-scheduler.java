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
    
    public int leastInterval(char[] tasks, int n) {
        
        //count the freq of all tasks
        // have a PQ which pulls the max freq on the top
        // if remaining freq is >0 keep in a temp storage.
        // reduce n everytime you chose an elemenet.
        //if heap goes empty then you have to chose add cooldown so add it in the count
        int count [] = new int [26];
        for(int i=0; i < tasks.length; i++){
            count[tasks[i]-'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int c: count) {
            if(c>0) maxHeap.offer(c);
        }
        
        int total=tasks.length; //atleast cycles for total tasks
        
        while(!maxHeap.isEmpty()){
            int k =n+1;
            List<Integer> temp = new ArrayList<>();
            while(k>0 && !maxHeap.isEmpty()) {

                k--;
                int freq = maxHeap.poll();
                if(--freq>0){
                    temp.add(freq);
                }                
            }
            maxHeap.addAll(temp);
            if(maxHeap.isEmpty()) break;//nothing to schedule.
            total+=k;    
        }
        
        return total;
    }
    public int leastInterval2(char[] tasks, int n) {
            
        int [] counts = new int[tasks.length];
        for(char task : tasks) {
            counts[task - 'A']++;
        }
        //we create a max heap which gives chars with heightest count left.
        //since we need to add a gap of n if we get an element from the heap we will have to keep
        //this one in reserve until we have used up n tasks.
        //what we create an queue like structure where we put an element 
    //keep a count if how many tasks we have included and pull the task in the array at position 
        //currnt eleemtn selected count - n : if it is still eleibilihge with heighest count we will select it
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparing(x-> x.count));
        
        for(int i=0;i < counts.length; i++) {
            if(counts[i]>0){
                maxHeap.offer(new Pair((char)(i+'A'), counts[i]));
            }
            
        }
        Map<Character, Integer> lastIndex = new HashMap<>();
        Map<Character, Pair> charToPair = new HashMap<>();
        List<Character> result = new ArrayList<>();
        int currentIndex =0;
        int totalCharsIncluded =0;
        while(true) {
            System.out.println(lastIndex);
            System.out.println(charToPair);
            //figuree out if any element can be reincluded now?
            if(lastIndex.size()>0 && currentIndex > 0) {
                int minIndex =Integer.MAX_VALUE;
                HashSet<Character> toRemove = new HashSet<>();
                for(Map.Entry<Character, Integer> entry: lastIndex.entrySet()){
                    if( currentIndex - entry.getValue() > n) {
                        maxHeap.offer(charToPair.get(entry.getKey()));
                        toRemove.add(entry.getKey());
                    }
                    minIndex=Math.min(minIndex, entry.getValue());
                }
                toRemove.stream().forEach(x-> lastIndex.remove(x));
                
                if(maxHeap.isEmpty()) {
                //you need to add some blanks now/
                    while(currentIndex - minIndex <= n){
                        result.add(' ');
                        currentIndex++;
                    }  
                    toRemove = new HashSet<>();
                    for(Map.Entry<Character, Integer> entry: lastIndex.entrySet()){
                        if(currentIndex - entry.getValue() > n) {
                            maxHeap.offer(charToPair.get(entry.getKey()));
                            toRemove.add(entry.getKey());
                        }
                        
                    }
                    toRemove.stream().forEach(x-> lastIndex.remove(x));
                }
            
               
                
                
            }
            System.out.println("result "+ result);
            //how to add blanks?
            //lets say queue is still empty
            if(maxHeap.isEmpty()) break;
            Pair p=maxHeap.poll();
            result.add(p.c);
            p.count--;
            if(p.count>0){
                charToPair.put(p.c, p);
                lastIndex.put(p.c, currentIndex);    
            }
            
            currentIndex++;
        }
        System.out.println(result);
        return 5;
    }
    public int leastInterval1(char[] tasks, int n) {
        
      /* we count number of tasks of each type.
      one way is to keep picking the character which occurs the most and park this character for n more slots.
      before considering it again.
      
        we pick a char and now we don'ty know if n slots of chars and idle are passed.
        buit this is certain that the one with max frequency should be picked first.
        between 2 frequencies of A what all other characters can we insert? 
        
        A _ _ A _ _ A -> we have 3 As then it will have a gap 3-1
        the size of gap wilol be n.
        now we pick other characters which can be placed here but how?
        if we use first blank and keep filling this posoiiton + n withe other charcter - it can be done
        
        
        either we keep counting how many blank spaces we need.
        so in the above example that si the blank spaces we need but if ther c and b which also occur 3 times then
        
        A B C A B C A B C - blank spaces were 4 but we had more characaters thn blank spaces pssible
        if we condier this as min spaces required to arrange and keep reducing by the number of charaters we have
        at the end blank spaces will go negative right? 
        Greedily pick the most frequency element to create tasks.
        */
        // IF WE KNOW EACH CHARACTER:
        int[] count = new int[26];
        int maxFreq=0;
        for(char c: tasks) {
            count[c-'A']++;
            if(maxFreq< count[c- 'A']){
                maxFreq = count[c-'A'];
            }
        }
        int findElementsWithMaxFreq=0;
        HashSet<Character> set =new HashSet<>();
        for(char c: tasks) {
            if(maxFreq==count[c-'A']){
                set.add(c);
            }
        }
        findElementsWithMaxFreq =set.size();
        
        int gaps = maxFreq-1;
        int perGapSize = n - findElementsWithMaxFreq + 1;
        
        
        int minBlanks= perGapSize * gaps;
        
        //minBlnaks represnt ths blank between each group of chars with heighest frequency.
        int leftOverCharacters = tasks.length - (findElementsWithMaxFreq* maxFreq);
        // if min blanks required are used up then we can arrange all charactare somehow without any extra idle wait times.
        return tasks.length + ( minBlanks-leftOverCharacters <0? 0: minBlanks-leftOverCharacters);
    }
}