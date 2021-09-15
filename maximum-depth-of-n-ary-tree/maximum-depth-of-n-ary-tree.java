/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        //dfs from each node to its left and get the maximym
        //bfs and get until the end
        //dfs will give a better space complexity
        if(root == null) return 0;
        List<Node> child = root.children;
        int max = 0;
        for(Node c: child){
            int h = maxDepth(c);
            max = Math.max(max, h);
        }
        return max+1;
        
    }
}