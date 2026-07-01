class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int res = 0;
        int l=0;
        for(int r=0; r<s.length(); r++){
            char cr = s.charAt(r);
            //validate windows
            while(set.contains(cr)){
                char cl = s.charAt(l);
                set.remove(cl);
                l++;
            }
            set.add(cr);
            //already valid 
            res = Math.max(res, (r-l+1));
        }
        return res;
    }
}
