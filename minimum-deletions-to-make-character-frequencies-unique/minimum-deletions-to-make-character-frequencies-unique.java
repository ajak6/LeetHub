class Solution {
    public int minDeletions(String s) {
        
        // no two diff character in s that have same frequency
        //count frequency of each character.
        //find the min frequency
        //now you need to start from min frequency.\
        //next frequency will be what? you need min frequency
        // if we have 1 and 5,5 -> then we only need 1 move 
        // either you check which frequency is not used
        //at the end some characters may be completely gone.
        /*
        a- 1
        b- 5
        c- 5 -> 4 and 1 is the answer
        either you pick a clashing frequency
        loop over existing frequency and try to find a missing on.
        once you find it count the diff between that number ad current frequency.
        but we will need to keep track of count of frequency as well
        if 2 chars are of same frequeny then you have to resolve it other wise not.
        
        you pick the freu which are clashing
        then try to find a frequency which is not seen yet and count the diff.
        
        */
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        
        HashSet<Integer> freq = new HashSet<>();
        AtomicInteger count = new AtomicInteger();
        System.out.println("All freq "+map);
        //add all uniqu frequeny oncecs and repeat ones will be collected separately
        List<Integer> repeats = new ArrayList<>();
        for(int i: map.values()){
            if(!freq.add(i)){
                repeats.add(i);
            }
        }
        //how do we make sure it gives minimum answer. 
        repeats.stream().sorted(Comparator.reverseOrder()).forEach(f -> {
            
            if(freq.contains(f)){ //if already [resent]
                System.out.println("Already present "+ f);
                for(int i=f; i>0 ;i--) {
                    System.out.println("trying "+ i);
                    if(freq.contains(i)){
                        System.out.println("present "+ i);
                        count.incrementAndGet();
                    }else {
                        freq.add(i);
                        break;
                    }
                    
                }
            }
        });
        
        return count.intValue();
    }
}