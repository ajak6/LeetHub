class Solution {
    public int minDeletions(String S){
         //store the count of each character, since its given we will only have lower case letter, length of 26 is fine.@interface

        int charCount [] = new int[26];
        for(int i=0 ; i < S.length(); i++){
            charCount[S.charAt(i) - 'a']++;
        }

        Arrays.sort(charCount);
        //now the last index should have max freq of any character
        /*
        Since we cannot add any characters to make diff frequency, expect all chars to have freq less than the max freq
         */
        
        int expectedFreq=charCount[charCount.length-1]-1;
        int charsToRemove = 0;
        for(int i = charCount.length-2; i>=0;i--) {
            if(charCount[i]==0) break;
            //either the freq of char is higher than expected or low
            //if it is higher we know we cannot allow it and we make the frequency equal to expected freq
            //the diff between expected and actual is what we need to rmeove from the string
            if (charCount[i] > expectedFreq){
                charsToRemove+=charCount[i]-expectedFreq;
                expectedFreq--;
            } else {
                expectedFreq=charCount[i]-1;
            }
            //if there are many chars with single freq we cannot expect to have negative freq, in such cases we just want to rermove these characters
            //except 1
            if(expectedFreq<0)expectedFreq=0;

        }
        return charsToRemove;
    }
    public int min2Deletions(String s) {
        int freq [] = new int [26];
        
        for(char c : s.toCharArray()) {    
            freq[ c-'a' ]++;
        }
        int res =0;
        Arrays.sort(freq);
        int exp = freq[25];
        
        for(int i=25;i >=0 ; i--){
            if(freq[i]==0)return res;
            if(exp<freq[i]){
                res+= freq[i]-exp;
            }else{
                exp = freq[i];    
            }
            if(exp >0) {
                //next expectation is 1 less atleast if it lower than that that's good.
                exp--;
            }
            
        }
        return res;
    }
    public int minDeletions1(String s) {
        int freq [] = new int [26];
        
        for(char c : s.toCharArray()) {    
            freq[ c-'a' ]++;
        }
        int res =0;
        //since we only have 26 characters. count will also be different 26 numbers max: bnut cannoy be index like this
        //"aaabbbcc"
        //"bbcebab"
        Set<Integer> set = new HashSet<>();

        for( int i =0; i < freq.length; i++){
            int curr = freq[i];
            
            if(freq[i]==0)continue;
            while(set.contains(curr)){
                curr--;
                res++; 
            }
            if(curr!=0)
                set.add(curr);
            // find out the number 
        }
        return res;
    }
}