class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        r = len(s) - 1  # Start from the last index
        l = 0
        
        while r >= l:

            if not s[r].isalnum():
                r -= 1
                continue
                
            if not s[l].isalnum():
                l += 1
                continue

            if s[r] != s[l]:
                return False
            
            r -= 1
            l += 1
        
        return True




        