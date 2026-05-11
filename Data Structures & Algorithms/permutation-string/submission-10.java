class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        int l=0;

        for(Character c: s1.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(int r=0; r<s2.length(); r++){
            map2.put(s2.charAt(r),map2.getOrDefault(s2.charAt(r),0)+1);
            while((r-l+1) > s1.length()){
                if(map2.get(s2.charAt(l)) > 1){
                    map2.put(s2.charAt(l),map2.get(s2.charAt(l)) - 1);
                }else{
                    map2.remove(s2.charAt(l));
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
