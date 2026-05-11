class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> ms = new HashMap<>();
        Map<Character,Integer> mt = new HashMap<>();

        for(int i=0;i<s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            ms.put(cs,ms.getOrDefault(cs,0)+1);
            mt.put(ct,mt.getOrDefault(ct,0)+1);
        }

        return ms.equals(mt);
    }
}
