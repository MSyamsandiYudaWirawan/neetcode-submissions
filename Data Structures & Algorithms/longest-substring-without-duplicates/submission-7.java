class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        int l=0;

        for(int r=0; r<s.length(); r++){
            char cr = s.charAt(r);
            char cl = s.charAt(l);
            while(set.contains(cr)){
                set.remove(cl);
                l++;
                cl = s.charAt(l);
            }
            set.add(cr);
            result = Math.max(result,r-l+1); 
        }
        return result;
    }
}
