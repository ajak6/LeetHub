class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        
        //23 keyts
        // type
        //color
        //name
        Map<String, Integer> type = new HashMap<>();
        Map<String, Integer> color = new HashMap<>();
        Map<String, Integer> name = new HashMap<>();
        for(List<String> item: items){
            type.merge(item.get(0), 1, Integer::sum);
            color.merge(item.get(1), 1, Integer::sum);
            name.merge(item.get(2), 1, Integer::sum);
        }
        Map<String, Integer> result; 
        System.out.println(ruleKey);
        if(ruleKey.equals("color")) 
            result=color;
        else if(ruleKey.equals("name"))
            result = name;
        else result=type;
        System.out.println(result);
        return result.getOrDefault(ruleValue,0);

    }
}