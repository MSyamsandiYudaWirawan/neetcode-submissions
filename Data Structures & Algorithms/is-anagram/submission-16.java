class Solution {
    public boolean isAnagram(String s, String t) {

        int[] count = new int[26];
        if(s.length() != t.length()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            char c_s = s.charAt(i);
            char c_t = t.charAt(i);
            count[c_s - 'a']++;
            count[c_t - 'a']--;
        }
        for(int c_sum : count){
            if(c_sum != 0){
                return false;
            }
        }
        return true;
    }
}
