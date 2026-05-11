class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int maxf = 0;
        for(int r=0; r<s.length(); r++){
            char cr = s.charAt(r);
            map.put(cr,map.getOrDefault(cr,0)+1);
            maxf = Math.max(maxf,map.get(cr));
            while((r-l+1) - maxf > k){
                char cl = s.charAt(l);
                if(map.get(cl) > 1){
                    map.put(cl,map.get(cl) - 1);
                }
                else{
                    map.remove(cl);
                }
                l++;
            }
            result = Math.max(result,(r-l+1));
        }
        return result;
    }
}
