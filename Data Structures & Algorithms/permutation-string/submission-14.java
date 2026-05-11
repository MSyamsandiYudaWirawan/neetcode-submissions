class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int l=0;
        Map<Character,Integer> m1 = new HashMap<>();
        Map<Character,Integer> m2 = new HashMap<>();
        for(char c:s1.toCharArray()){
            m1.put(c,m1.getOrDefault(c,0) + 1);
        }
        for(int r=0;r<s2.length();r++){
            char cr = s2.charAt(r);
            m2.put(cr,m2.getOrDefault(cr,0)+1);

            if((r-l+1) > s1.length()){
                char cl = s2.charAt(l);
                if(m2.get(cl)>1){
                    m2.put(cl,m2.get(cl) - 1);
                }else{
                    m2.remove(cl);
                }
                l++;
            }


            if((r-l+1) == s1.length() && m1.equals(m2)){
                return true;
            }
           
        }
        return false;

    }
}
