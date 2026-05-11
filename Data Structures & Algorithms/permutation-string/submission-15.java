class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        Map<Character,Integer> map_need = new HashMap<>();
        Map<Character,Integer> map_have = new HashMap<>();

        for(char c:s1.toCharArray()){
            map_need.put(c,map_need.getOrDefault(c,0) + 1);
        }

        int l = 0;
        for(int r = 0; r<s2.length(); r++){
            char cr = s2.charAt(r);
            map_have.put(cr,map_have.getOrDefault(cr,0) + 1);

            while((r-l+1) > s1.length()){
                char cl = s2.charAt(l);
                if(map_have.get(cl) > 1){
                    map_have.put(cl,map_have.get(cl) - 1);
                }else {
                    map_have.remove(cl);
                }
                l++;
            }
            if((r-l+1) == s1.length() && map_need.equals(map_have)){
                return true;
            }
        }
        return false;
    }
}
