/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //do top level and put it in a stack
        // once done pop the stack and put it in the list and return.
        // or we do level order traversal and reverse the result string.
        
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.offer(root);
        List<Integer> level = new LinkedList<>();
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root==null) return result;
        
            
        while(!queue.isEmpty()){
            int size = queue.size();
            level = new LinkedList<>();
            while(size>0){
                TreeNode n  = queue.poll();
                size--;
                level.add(n.val);
                if(n.left!= null)
                   queue.offer(n.left);
                if(n.right!= null)
                    queue.offer(n.right);
            }
            result.addFirst(level);
            
        }
        
        return result;
        
    }
}