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
        ListNode prevGroupTail = dummy;
        while(true){
            ListNode groupTail = getKth(prevGroupTail,k);
            if(groupTail==null){
                break;
            }
            ListNode groupHead = prevGroupTail.next;
            ListNode nextGroupHead = groupTail.next;

            // reverse
            ListNode curr = groupHead;
            ListNode prev = null;
            while(curr != nextGroupHead){
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            //after reverse prev = new head and groupHead = new tail
            //reconnect
            prevGroupTail.next = prev;
            groupHead.next = nextGroupHead;
            //shift prevGroupTail to tail
            prevGroupTail = groupHead;
        }
        return dummy.next;

    }
    private ListNode getKth(ListNode head,int k){
        ListNode curr = head;
        while(curr != null && k>0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
