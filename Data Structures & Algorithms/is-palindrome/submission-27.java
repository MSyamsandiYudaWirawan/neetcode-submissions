class Solution {
    public boolean isPalindrome(String s) {
        int l=0;
        int r=s.length() - 1;
        while(l<=r){
            while(l<=r && !isAlnum(s.charAt(l))){
                l++;
            }
            while(l<=r && !isAlnum(s.charAt(r))){
                r--;
            }
            if(l<=r && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
        
    }
    private boolean isAlnum(char c){
        return (c>='A' && c<='Z') ||(c>='a' && c<='z') || (c>='0' && c<='9');
    }
}
