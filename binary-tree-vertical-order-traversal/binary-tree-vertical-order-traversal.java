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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> list = new TreeMap<>();
        
        // create(root, list, 0);
        if(root == null) return new ArrayList<>(list.values());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> col = new LinkedList<>();
        col.add(0);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int c = col.poll();
            
            list.computeIfAbsent(c, x-> new ArrayList<>()).add(node.val);
            if(node.left!=null)
            {
                queue.offer(node.left);
                col.offer(c-1);
            }
            if(node.right!=null){
                queue.offer(node.right);
                col.offer(c+1);
            }
                
        }
        return new ArrayList<>(list.values());
    }
    
    public void create(TreeNode root, TreeMap<Integer, List<Integer>> list, int vertical){
        if(root==null)return;
        list.computeIfAbsent(vertical, x-> new ArrayList<>()).add(root.val);
        create(root.left, list, vertical-1);
        create(root.right, list, vertical + 1);
        
    }
}