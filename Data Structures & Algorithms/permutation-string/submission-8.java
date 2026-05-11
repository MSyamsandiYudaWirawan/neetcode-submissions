class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> maps1 = new HashMap<>();
        Map<Character,Integer> maps2 = new HashMap<>();

        int l=0;
        for(char c:s1.toCharArray()){
            maps1.put(c,maps1.getOrDefault(c,0) + 1);
        }
        
        for(int r=0; r<s2.length(); r++){
            char cr = s2.charAt(r);
            maps2.put(cr, maps2.getOrDefault(cr,0) + 1);
            if(s1.length() < (r-l+1)){
                char cl = s2.charAt(l);
                if(maps2.get(cl) > 1){
                    maps2.put(cl,maps2.get(cl) - 1);
                }
                else{
                    maps2.remove(cl);
                }
                l++;
            }
            if(maps1.equals(maps2)){
                return true;
            }
        }
        return false;

    }
}
