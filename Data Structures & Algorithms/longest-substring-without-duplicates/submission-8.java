class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        for(int r=0; r< s.length(); r++){
            char cr = s.charAt(r);
            char cl = s.charAt(l);
            while(set.contains(cr)){
                l++;
                set.remove(cl);
                cl = s.charAt(l);
            }
            set.add(cr);
            result = Math.max(result,(r-l+1));
        }
        return result;
    }
}
