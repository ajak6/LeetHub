class Solution {
    public int maximumSwap(int num) {
        //find the position of max number
        //12345 -> highest number 52341
        //312978 
        //neatve numbers?
        //what if the number goes out of range by doing it?
    //happy case
        // find the heighest digit and move it to first place
        // in case the max digit appears multiple times we want to pick the right most
        //in case t he first is height but second is not 
        // 999123 -> so track the location of both swap locations
        //1993 -> swap the second 9 not the first one;
        /* 19239 - > 
        Brute force: pick a number find the heighest number from in the right if found you are good break
        
        pick the second char and search for a heigher number in the right break when found after sawapping.
        */
        //find the inde where upward trend starts from the left
        // post that find the max heigher than the number at that location
        
        
        char [] c = String.valueOf(num).toCharArray();
        
        for(int i =0 ; i < c.length ;i++) {
            int min = i;
            // System.out.println("looking for" + c[i]);
            for(int j =i+1; j < c.length; j++) {
                System.out.println("compare to " + c[j]);
                if(c[min] <= c[j]){
                    min=j;
                }
            }    
            // System.out.println("min " + min + " i "+ i);
            if(min !=i && c[min] != c[i]) {
                swap(c, min, i);
                return Integer.parseInt(new String(c));
            }
        }
        return num;
    }
    
    public void swap(char c[], int i , int j){
        char cc = c[i];
        c[i]=c[j];
        c[j]=cc;
    }
}