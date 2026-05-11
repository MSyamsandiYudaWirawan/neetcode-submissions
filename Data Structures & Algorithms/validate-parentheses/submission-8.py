class Solution:
    def isValid(self, s: str) -> bool:
        hm = {'(' : ')','{' : '}','[' : ']'}
        openB = []

        for i in range(len(s)):
            if s[i] in hm:
                openB.append(s[i])
            else:
                if not openB or s[i]!=hm[openB[-1]]:
                    return False
                openB.pop()
        
        return not openB