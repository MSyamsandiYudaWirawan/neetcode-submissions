class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() !=t.length()){
            return false;
        }
        Map<Character, Integer> ms = new HashMap<>();
        Map<Character, Integer> mt = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            ms.put(s.charAt(i), ms.getOrDefault(s.charAt(i),0) + 1);
            mt.put(t.charAt(i), mt.getOrDefault(t.charAt(i),0) + 1);
        }

        return ms.equals(mt);

    
    }
}
