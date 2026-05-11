class Solution:
    def isValid(self, s: str) -> bool:
        Map = {"(": ")", "[": "]", "{": "}"}
        stack = []

        for c in s :
            if c in Map:
                stack.append(c)
            else:
                if not stack or Map[stack.pop()] != c:
                    return False
            
        return not stack
    