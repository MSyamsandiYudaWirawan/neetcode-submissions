class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l=0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        for(int r = 0; r<s.length(); r++){
            char cr = s.charAt(r);
            while(set.contains(cr)){
                char cl = s.charAt(l);
                set.remove(cl);
                l++;
            }
            set.add(cr);
            res = Math.max(res,(r-l+1));
        }
        return res;
        
    }
}
