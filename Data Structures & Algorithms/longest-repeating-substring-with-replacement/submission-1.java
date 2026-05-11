class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int maxf=0;
        int result=0;
        int l=0;

        for(int r=0; r<s.length(); r++){
            char cr = s.charAt(r);
            char cl = s.charAt(l);
            map.put(cr,map.getOrDefault(cr,0)+1);
            maxf = Math.max(maxf,map.get(cr));
            while((r-l+1) - maxf > k){
                map.put(cl,map.get(cl)-1);
                l++;
            }
            result = Math.max((r-l+1),result);
        }
        return result;

    }
}
