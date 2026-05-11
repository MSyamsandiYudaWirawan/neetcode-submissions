class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character,Integer> mapS1 = new HashMap<>();
        Map<Character,Integer> mapS2 = new HashMap<>();

        for(char c:s1.toCharArray()){
            mapS1.put(c,mapS1.getOrDefault(c,0)+1);
        }
        int l=0;
        for(int r=0; r< s2.length(); r++){
            char cr = s2.charAt(r);
            char cl = s2.charAt(l);
            mapS2.put(cr,mapS2.getOrDefault(cr,0)+1);

            while((r-l+1) > s1.length()){
                if (mapS2.get(cl) == 1) {
                    mapS2.remove(cl);
                } else {
                    mapS2.put(cl, mapS2.get(cl) - 1);
                }
                l++;
            }
            
            if (r - l + 1 == s1.length() && mapS1.equals(mapS2)) {
                return true;
            }
        }
        return false;
    }

   
}
