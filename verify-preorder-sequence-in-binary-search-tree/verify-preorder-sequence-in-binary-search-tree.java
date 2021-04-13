class Solution {
    public boolean verifyPreorder(int[] preorder) {
        
        //bst if increasing order
        // given an array, every element will be a root and followed by its left subtree and right substree
        // at every level of bst there are 2 ^ h nodes max. can we compare using this property?
        // pick an instance / count the level and if level is zerp you run the loop for 1 iteration and pick an element.
        // next level pick two elememnts= it will be error prone. to pick the child nodes// we may be able to use property of head
        //a child of a node is present atindex determines the position
        //2n-1 is left 2n is right child.
        // but that will be head order not preorder.
        //how about we
        
        //usings tack to write preorder.check the 
        //can we reconstruct the tree?
        /*
            root - left subtree - right subtree
            index we can start at 0
            5, next element should be left sub tree
            total size of the array can give us the number of levels? its hard to tell it is a balanced tree or not.
            
            save 5 and push 2 in the stack.
            5 comes 2 comes 1 comes  comes 3 -> 
            
            
        
        */    
        Stack<Integer> stack= new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int i=0; i < preorder.length ; i++) {
            
            if(preorder[i] < min)return false;
            // once we remove an element from the stack. the last elelemt will be possible root of the tree and if once we have  found an element greater than a root i.e. right tree then all alemenets should also be greater than the root who right child we just visited
            if(stack.isEmpty() || preorder[i] < preorder[i-1]){
                stack.push(preorder[i]); //if it is decreasing you keep pushing to stack
                
            }else {
                while (!stack.isEmpty() && stack.peek() < preorder[i]) {
                    min=stack.pop();
                }
            }
            stack.push(preorder[i]);
            
        }
        return true;
    }
}