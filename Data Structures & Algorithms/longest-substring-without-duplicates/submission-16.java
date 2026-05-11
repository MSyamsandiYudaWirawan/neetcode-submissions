class Solution {
    public int lengthOfLongestSubstring(String s) {
      Set<Character> set = new HashSet<>();
      int maxL = 0;
      int l=0;
      for(int r=0; r<s.length(); r++){
        //isWindowValid
        while(set.contains(s.charAt(r))){
            set.remove(s.charAt(l));
            l++;
        }
        set.add(s.charAt(r));
        maxL = Math.max(maxL,set.size());
      }
      return maxL;
    }
}
