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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = head;
        //shift right with offset n + 1;
        while(n>0){
            right = right.next;
            n--;
        }
        //shift both left and right till right = null
        while(right != null){
            left = left.next;
            right = right.next;
        }
        // delete the Nth node
        left.next = left.next.next;
        return dummy.next;
    }
}
