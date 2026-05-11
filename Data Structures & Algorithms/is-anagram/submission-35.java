class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            maps.put(cs,maps.getOrDefault(cs,0) + 1);
            mapt.put(ct,mapt.getOrDefault(ct,0) + 1);
        }
        return maps.equals(mapt);
    }

}
