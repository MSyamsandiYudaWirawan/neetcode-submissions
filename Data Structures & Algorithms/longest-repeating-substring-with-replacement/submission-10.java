class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int max_count = 0;
        int res = 0;
        for(int r = 0; r<s.length(); r++){
            char cr = s.charAt(r);
            map.put(cr, map.getOrDefault(cr,0) + 1);
            max_count = Math.max(max_count, map.get(cr));

            while((r-l+1) > k + max_count){
                char cl = s.charAt(l);
                if(map.get(cl) > 0){
                    map.put(cl,map.get(cl) - 1);
                }
                else {
                    map.remove(cl);
                }
                l++;
            }
            
            res = Math.max(res,(r-l+1));
        }
        return res;
        
    }
}
