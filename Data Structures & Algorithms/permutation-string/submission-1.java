class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int[] windowCount = new int[26];
        int windowLength = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            windowCount[s2.charAt(i) - 'a']++;

            if (i >= windowLength) {
                windowCount[s2.charAt(i - windowLength) - 'a']--;
            }

            if (matches(s1Count, windowCount)) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[] s1Count, int[] windowCount) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != windowCount[i]) {
                return false;
            }
        }
        return true;
    }
}
