class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int res = 0;
        for(int r = 0; r<s.length(); r++){
            char cr = s.charAt(r);
            while(set.contains(cr)){
                char cl = s.charAt(l);
                set.remove(cl);
                l++;
            }
            res = Math.max(res,(r-l+1));
            set.add(cr);
        }
        return res;
    }
}
