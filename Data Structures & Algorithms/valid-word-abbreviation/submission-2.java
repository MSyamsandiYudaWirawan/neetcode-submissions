class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int w = 0;
        int a = 0;
        int w_len = word.length();
        int a_len = abbr.length();

        while(a < a_len && w < w_len){
            if(abbr.charAt(a) == '0'){
                return false;
            }
            if(Character.isLetter(abbr.charAt(a))){
                if(w < w_len && word.charAt(w) == abbr.charAt(a)){
                    a++;
                    w++;
                }
                else{
                    return false;
                }
            }
            else{
                int subLen = 0;
                while(a<a_len && Character.isDigit(abbr.charAt(a)) ){
                    subLen = subLen * 10 + (abbr.charAt(a) - '0');
                    a++;
                }
                w+=subLen;
            }
            
        }
        return w == w_len && a==a_len;
    }
}