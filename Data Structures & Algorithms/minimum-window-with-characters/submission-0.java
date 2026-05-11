class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        Map<Character,Integer> map_need = new HashMap<>();
        Map<Character,Integer> map_have = new HashMap<>();
        
        for(char c:t.toCharArray()){
            map_need.put(c,map_need.getOrDefault(c,0) + 1);
        }

        int have = 0;
        int need = map_need.size();

        String res = "";
        int res_len = Integer.MAX_VALUE;
        int l = 0;
        for(int r=0; r<s.length(); r++){
            char cr = s.charAt(r);
            map_have.put(cr,map_have.getOrDefault(cr,0) + 1);
            if(map_need.containsKey(cr) && map_need.get(cr) == map_have.get(cr)){
                have++;
            }

            while(have == need){
                if(res_len > (r-l+1)){
                    res = s.substring(l,r+1);
                    res_len = r-l+1;
                }
                char cl = s.charAt(l);
                map_have.put(cl, map_have.get(cl) - 1);
                l++;
                if(map_need.containsKey(cl) && map_need.get(cl) > map_have.get(cl)){
                    have--;
                }
            }
        }
        return res;    
    }
}
