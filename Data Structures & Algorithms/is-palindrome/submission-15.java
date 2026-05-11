class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() -1;

        while(r>l){
            while(r>l && !isAlnum(s.charAt(r))){
                r--;
            }
            while(r>l && !isAlnum(s.charAt(l))){
                l++;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public  boolean isAlnum(Character c){
        return ((c >= 'a' && c<= 'z')||
                (c >= 'A' && c<= 'Z')||
                (c >= '0' && c<= '9')
        );
    }
    
}
