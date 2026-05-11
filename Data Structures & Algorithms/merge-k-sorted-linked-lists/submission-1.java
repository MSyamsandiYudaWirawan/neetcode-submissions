/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a,b) -> a.val - b.val
        );
        for(ListNode head:lists){
            if(head != null){
                minHeap.add(head);
            }
        }
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null){
                minHeap.add(node.next);
            }
        }
        return dummy.next;
    }
}
