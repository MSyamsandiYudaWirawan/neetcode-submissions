# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        f=head.next 
        s=head

        while f and f.next:
            if f==s:
                return True
            f=f.next.next
            s=s.next

        return False