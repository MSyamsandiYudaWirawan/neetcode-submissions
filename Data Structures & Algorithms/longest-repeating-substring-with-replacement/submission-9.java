class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int l=0;
        int maxFreq=0;
        int res = 0;
        for (int r=0; r<s.length(); r++){
            char cr = s.charAt(r);
            map.put(cr,map.getOrDefault(cr,0)+1);
            maxFreq = Math.max(maxFreq,map.get(cr));
            while((r-l+1) > maxFreq + k){
                char cl = s.charAt(l);
                if(map.get(cl) > 1){
                    map.put(cl,map.get(cl)-1);
                }else{
                    map.remove(cl);
                }
                l++;
            }
            res = Math.max(res,(r-l)+1);
        }
        return res; 
    }
}
