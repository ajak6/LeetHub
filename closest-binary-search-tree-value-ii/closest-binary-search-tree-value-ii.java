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

class Pair{
    int num;
    double diff;
}
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // k closest values to a number.
        // find the number and all values in the inorder list.//
        // you don't how many next numbers are so you won't be able to pick the numbers from lower half
        // target may not be oresent in the tree as wellkeep calculating the distance between target and numbers and maintain a heap of k size
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(d-> -d.diff));
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            if(stack.isEmpty())break;
            root=stack.pop();
            Pair  p =new Pair();
            p.diff=Math.abs(target-root.val);
            p.num=root.val;
            queue.offer(p);
            if(queue.size()>k){
                queue.poll();
            }
            root=root.right;
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            result.add(p.num);
        }
        return  result;
    }
}