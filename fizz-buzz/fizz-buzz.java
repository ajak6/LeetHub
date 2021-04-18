class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> list = new ArrayList<>();
        
        for(int i =1 ; i <=n ; i++) {
            
            String s = "";
            if(i%3==0){
                s=s+"Fizz";
            }
            if(i%5==0){
                s=s+"Buzz";
            }
            s=s.isBlank()? String.valueOf(i): s;
            list.add(s);
        }
        return list;
    }
}