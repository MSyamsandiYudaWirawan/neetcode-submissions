class Solution:
    def isValid(self, s: str) -> bool:
        Map = {"(": ")", "[": "]", "{": "}"}
        stack = []

        for c in s:
            if c in Map:
                stack.append(c)
            else:
                if not stack or c != Map[stack.pop()] :
                    return False
        return not stack