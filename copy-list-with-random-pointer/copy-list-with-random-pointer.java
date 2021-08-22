/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> nodeToNode = new HashMap<>();
        Node prev=null;
        Node temp = head;
        Node h = head;
        while(head!=null){
            Node n = new Node(head.val);
            //we want to link the previous nodes next to this new node
            if(prev!=null){
                prev.next=n;
            }
            nodeToNode.put(head, n);
            // nodeToNode(n, head);
            prev = n;
            head = head.next;
        }
        
        while(temp!=null){
            Node copyNode = nodeToNode.get(temp);
            copyNode.random = nodeToNode.get(temp.random);
            temp=temp.next;
        }
        return nodeToNode.get(h);
    }
}