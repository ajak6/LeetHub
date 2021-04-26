/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        
        //q is the hcild tree of p then p is LCA
        //p and q are in separete tree then traverse to common parent going up the chain.
        //
        
        // usually you picjk a node in the root and traverse in left and right and if both return truee it means
        //in a recursion if it find sa the target node then it returns this node.
        // a node will check its left recursion result and right rescursion resopinse 
        //if both return p and q it means itself is the LVA
        // recursion above it will just see that ionly one of the left and right return a non null node.
        //     they will keep passng it upwards and hence it will become the result egventuall.
        /*
            but now when only 2 nodes are givien and they point to their parent
            each node traverse up the stream and find out
            //how will we converge in this case.
            //either you traverse one by one 
        
          */
        
        HashSet<Node> tree = new HashSet<>();
        
        while(p!=null){
            tree.add(p);
            p=p.parent;
        }
        Node result=null;
        while(q!=null) {
            if(tree.contains(q))return q;
            q=q.parent;
        }
        return result;
    }
}