# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        # hs = set()
        # curr = head;

        # while curr:
        #     if curr in hs:
        #         return True
        #     hs.add(curr)
        #     curr = curr.next
        # return False

        s=head
        f=head
        while f and f.next:
            s = s.next
            f = f.next.next
            if f == s:
                return True
        return False


        


        