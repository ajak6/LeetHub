/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        //flat the child
        //flat the next
        //add child to next
        // traverse child end and attach next flattened to its end and return head
        
        //get the flatten child node
        //attach to next and at the end of child node attach the next;
        // do the same to the end of child node.
        
        if (head!=null) {  
            
            Node child = flatten(head.child);
            Node next = flatten(head.next);
            head.child= null;
            if(child != null){
                head.next=child;
                child.prev=head;
                while(child.next!=null){
                    child=child.next;
                }
                child.next=next;
                if(next!=null)
                    next.prev = child;
            } 
            ///if child is null then we don't need to change anything for next it already next ibn head
        }
        // print(head);
        return head;       
    }
    
    public void print(Node head){
        Node last =null;
        while(head!=null){
            System.out.print(head.val +" > ");
            last=head;
            head=head.next;
        }
        System.out.println("\n reverse ");
        while(last!=null){
            System.out.print(last.val +" > ");
            last=last.prev;
            
        }
        System.out.println("");
        
    }
}