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
    public void reorderList(ListNode head) {
        //find middle
        //split the list
        //reverse second list
        //rearrange

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = head;
        ListNode second = slow.next;
        //cut off
        slow.next = null;
        //first 1,2,3
        //second 4,5,6

        //reverse
        ListNode prev = null;
        while(second != null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }
        //shift second to prev
        second = prev;

        //rearrange
        while(first != null && second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            //shift
            first = tmp1;
            second = tmp2;
        }
        
    }
}
