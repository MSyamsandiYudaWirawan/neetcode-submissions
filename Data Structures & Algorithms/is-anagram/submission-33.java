class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> map_s= new HashMap<>();
        Map<Character,Integer> map_t= new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            map_s.put(s.charAt(i),map_s.getOrDefault(s.charAt(i),0) + 1);
            map_t.put(t.charAt(i),map_t.getOrDefault(t.charAt(i),0) + 1);
        }
        return map_s.equals(map_t);
    }
}
