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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode groupPrev = dummy;
        while(true){
            ListNode kth = getKth(groupPrev, k);
            if(kth == null){
                break;
            }
            ListNode groupNext = kth.next;

            ListNode curr = groupPrev.next;
            ListNode prev = null;
            while(curr != groupNext){
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            //save new tail
            ListNode tail = groupPrev.next;
            // connect groupPrev to new head
            groupPrev.next = kth;
            // connect tail to groupNext;
            tail.next = groupNext;
            //shift groupPrev to tail
            groupPrev = tail;
        }
        return dummy.next;
    }
    private ListNode getKth(ListNode node,int k){
        ListNode curr = node;
        while(curr != null && k > 0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
