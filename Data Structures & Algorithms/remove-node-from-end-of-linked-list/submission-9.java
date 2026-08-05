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
        ListNode cur = new ListNode();
        cur.next = head;
        ListNode l = cur;
        ListNode r = head;

        // shift r to n
        while(n > 0){
            r = r.next;
            n--;
        }
        while(r != null){
            l=l.next;
            r=r.next;
        }
        l.next = l.next.next;
        return cur.next;
    }
}
