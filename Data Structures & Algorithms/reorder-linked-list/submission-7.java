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
        //1. find middle
        //2. split to 2 node list
        //3. reverese second node list
        //4. rearrange first and second node list

        // 1. 
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2.
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;

        // 3.
        ListNode prev = null;
        while(second != null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        } 

        // 4.
        second = prev;
        while(first != null && second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
