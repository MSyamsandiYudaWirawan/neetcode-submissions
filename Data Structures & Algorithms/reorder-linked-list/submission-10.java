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
        //split the list with slow fast pointer
        // reverse seconnd list
        // re arrange
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        } 
        ListNode first = head;
        ListNode second = slow.next;
        //cut off the list
        slow.next = null;
        //first 1,2,3
        //second 4,5,6
        

        //reverse
        ListNode curr = second;
        ListNode prev = null;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        // head is in prev;
        second = prev;

        //rearrange list
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
