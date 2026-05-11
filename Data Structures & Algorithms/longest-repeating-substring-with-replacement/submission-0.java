class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int result=0;
        int maxFreq=0;

        Map<Character,Integer> map = new HashMap<>();

        for(int r=0; r<s.length(); r++){
            char currentChar = s.charAt(r);
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);

            maxFreq= Math.max(maxFreq, map.get(currentChar));
            
            while((r-l+1) - maxFreq > k){
                char leftChar = s.charAt(l);
                map.put(leftChar,map.get(leftChar) - 1);
                l++;
            }
            result = Math.max(result,r-l+1);
            
        }
        return result;
    }
}
