class Solution {
    public int characterReplacement(String s, int k) {
       int l=0;
       int maxF=0;
       int res=0;
       Map<Character,Integer> map = new HashMap<>();
       for(int r=0; r<s.length(); r++){
            char cr = s.charAt(r);
            map.put(cr,map.getOrDefault(cr,0)+1);
            maxF = Math.max(maxF,map.get(cr));
            while((r-l+1)-maxF > k){
                char cl = s.charAt(l);
                if(map.get(cl) > 1){
                    map.put(cl,map.get(cl)-1);
                }else{
                    map.remove(cl);
                }
                l++;
            }
            res = Math.max(res,(r-l+1));

       }
       return res;
    }
}
