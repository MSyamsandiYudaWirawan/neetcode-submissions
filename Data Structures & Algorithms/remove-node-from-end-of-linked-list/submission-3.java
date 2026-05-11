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
        //sue 2 pointer left->dummy,right->head
        ListNode left = dummy;
        ListNode right = head;
        //shift right n times for offset
        while(n>0){
            right = right.next;
            n--;
        }
        //shift both left and right pointer until right == null
        while(right!=null){
            left = left.next;
            right = right.next;
        }
        //delete the nth node
        left.next = left.next.next;
        return dummy.next;

    }
}
