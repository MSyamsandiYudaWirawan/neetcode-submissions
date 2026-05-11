class Solution:
    def isValid(self, s: str) -> bool:
        hashmap = {'(' : ')','{':'}','[':']'}
        openB = []

        for i in range(len(s)):
            if s[i] in hashmap:
                openB.append(s[i])
            else:
                if not openB or hashmap[openB[-1]] != s[i]:
                    return False
                openB.pop()
            
        return not openB