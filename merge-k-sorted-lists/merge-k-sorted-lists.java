/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null) return null;
        
        PriorityQueue<ListNode> p = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode one, ListNode two){
                return one.val - two.val;
            }
        });
        
        //runs for k times
        for(int i=0 ;i<lists.length; i++){
            p.add(lists[i]);
        }
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while(!p.isEmpty()){
            ListNode pop = p.poll();
            p.add(pop.next);
            pop.next = null;
            temp.next = pop;
            temp=temp.next;   
        }
        
        return result.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists){
        
        return merge(lists, 0 , lists.length-1);
    }
    
    public ListNode merge(ListNode[] lists, int start, int end) {
        // System.out.println("start " + start + "end "+ end);
        if(end<start) return null;
        if(end==start) return lists[start];
        
        int mid = (start + end) / 2;
        
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid+1, end);
        
        if(left==null) return right;
        if(right==null) return left;
        
        ListNode result = new ListNode(0);
        ListNode head = result;
        while(left!=null || right!=null){
            if(left!=null && right!=null){
                if(left.val>right.val){
                    result.next=right;
                    right=right.next;
                }else{
                    result.next=left;
                    left=left.next;
                }
            }else if(left!=null){
                    result.next=left;
                    left=left.next;
            }else{
                result.next=right;
                right=right.next;
            }
            result=result.next;
            
        }
        return head.next;
    }
}