class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            while(l<r && !isValid(s.charAt(r))){
                r--;
            }
            while(l<r && !isValid(s.charAt(l))){
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
    private boolean isValid(char c){
        return (c >= 'a' && c <= 'z') ||
       (c >= 'A' && c <= 'Z') ||
        (c >= '0' && c <= '9');
    }
}
