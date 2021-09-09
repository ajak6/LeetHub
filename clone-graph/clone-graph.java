/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        Map<Node,Node> oldNew = new HashMap<>();
        Map<Node,Node> newOld = new HashMap<>();
        
        Deque<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(!oldNew.containsKey(curr)) {
                Node xx= new Node(curr.val);
                oldNew.put(curr, xx);
                newOld.put(xx, curr);
            }
            for(Node n : curr.neighbors) {
                if(!oldNew.containsKey(n)){
                    q.offer(n);
                }
            }
        }
  
        HashSet<Node> visited = new HashSet<>();
        for(Node newNode: newOld.keySet()){
            Node old = newOld.get(newNode);
            for(Node n: old.neighbors) {
                newNode.neighbors.add(oldNew.get(n));
            }
        }
        return oldNew.get(node);
    }
}