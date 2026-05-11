class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> map_s1 = new HashMap<>();
        Map<Character,Integer> map_s2 = new HashMap<>();

        for (int i=0; i<s.length(); i++){
            map_s1.put(s.charAt(i), map_s1.getOrDefault(s.charAt(i),0)+ 1);
            map_s2.put(t.charAt(i), map_s2.getOrDefault(t.charAt(i),0) + 1);
        }
        return map_s1.equals(map_s2);
    }
}
