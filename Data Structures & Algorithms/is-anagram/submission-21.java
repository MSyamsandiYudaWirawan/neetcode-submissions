class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> count_s = new HashMap<>();
        Map<Character,Integer> count_t = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            count_s.put(s.charAt(i),count_s.getOrDefault(s.charAt(i),0) + 1);
            count_t.put(t.charAt(i),count_t.getOrDefault(t.charAt(i),0) + 1);
        }
        return count_s.equals(count_t);
    }
}
