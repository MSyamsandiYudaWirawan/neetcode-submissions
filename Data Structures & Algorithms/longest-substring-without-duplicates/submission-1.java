class Solution {
    public int lengthOfLongestSubstring(String s) {
        int  l=0;
        Map<Character,Integer> map = new HashMap<>();
        int result=0;
        for(int r=0;r<s.length();r++){
            char currentChar = s.charAt(r);
            if(map.containsKey(currentChar)){
                l = Math.max(l, map.get(currentChar) + 1);
            }
            map.put(currentChar,r);
            result = Math.max(result,r-l+1);
        }
        return result;
    }
}
