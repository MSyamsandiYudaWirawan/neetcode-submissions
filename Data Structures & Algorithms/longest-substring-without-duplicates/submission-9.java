class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int l=0; 
        Set<Character> set = new HashSet<>();
        for(int r=0; r<s.length(); r++){
            char cr = s.charAt(r);
            while(set.contains(cr)){
                char cl = s.charAt(l);
                set.remove(cl);
                l++;
            }
            set.add(cr);
            result = Math.max(result,(r-l+1));
        }
        return result;
    }
}
