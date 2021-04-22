class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        //for each string coutn all its doman by the current count in the hashmapp
        // split by . and keep appending
        
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String s: cpdomains){
            String countsWords[] = s.split(" ");
            
            StringBuilder builder = new StringBuilder();
            String domains[] = countsWords[1].split("\\.");
            String counts = countsWords[0];
            // we may have to at the string in starting position which is bad for stringbuilder
            int count = Integer.parseInt(counts);
            String inProgressDomain= "";
            for(int i=domains.length-1; i >=0; i--) {
                inProgressDomain = domains[i] + inProgressDomain;
                // System.out.println(inProgressDomain);
                // result.add(counts + " "+ inProgressDomain);
                map.merge(inProgressDomain, count , Integer::sum);
                inProgressDomain ="."+ inProgressDomain;
            }
        }
        map.entrySet().forEach(entry-> {
           result.add(entry.getValue() + " "+ entry.getKey()); 
        });
        return result;
        
        
    }
}