class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int maxCount = 0;
        int l=0;
        for(int r=0; r<s.length(); r++){
            char cr = s.charAt(r);
            
            while(window.contains(cr)){
                char cl = s.charAt(l);
                window.remove(cl);
                l++;
            }
            window.add(cr);
            maxCount = Math.max(maxCount,window.size());
        }
        return maxCount;
    }
}
