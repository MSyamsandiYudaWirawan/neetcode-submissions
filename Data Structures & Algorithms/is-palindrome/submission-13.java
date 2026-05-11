class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;  // Initialize r to the last index

        // Continue while l is less than r
        while (l < r) {
            // Move l to the right until we find an alphanumeric character
            while (l < r && !isAlnum(s.charAt(l))) {
                l++;
            }
            // Move r to the left until we find an alphanumeric character
            while (l < r && !isAlnum(s.charAt(r))) {
                r--;
            }
            // If characters don't match (case-insensitive), return false
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            // Move both pointers towards the center
            l++;
            r--;
        }
        return true;  // If no mismatch is found, it's a palindrome
    }

    // Helper function to check if the character is alphanumeric
    public boolean isAlnum(char c) {
        return (c >= 'A' && c <= 'Z') ||
               (c >= 'a' && c <= 'z') ||
               (c >= '0' && c <= '9');
    }
}
