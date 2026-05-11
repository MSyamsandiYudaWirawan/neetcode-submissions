class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        int l=0;
        for(int r=0; r<s2.length(); r++){
            char cr = s2.charAt(r);
            map2.put(cr,map2.getOrDefault(cr,0)+1);
            if(s1.length() < (r-l)+1){
                char cl = s2.charAt(l);
                if(map2.get(cl) > 1){
                    map2.put(cl,map2.get(cl)-1);
                }
                else{
                    map2.remove(cl);
                }
                l++;
            }
            if(map1.equals(map2)){
                return true;
            }
        }
        return false;
    }
}
