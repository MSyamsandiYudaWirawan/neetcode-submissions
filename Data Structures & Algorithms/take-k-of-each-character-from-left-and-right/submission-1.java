class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0)
            return 0;
        int[] arr = new int[3];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }

        if (arr[0] < k || arr[1] < k || arr[2] < k) {
            return -1;
        }

        int[] windows = new int[3];
        int l = 0;
        int maxMiddle = 0;

        for (int r = 0; r < s.length(); r++) {
            char cr = s.charAt(r);

            windows[cr - 'a']++;

            while (arr[cr - 'a'] - windows[cr - 'a'] < k) {
                char cl = s.charAt(l);
                windows[cl - 'a']--;
                l++;
            }
            maxMiddle = Math.max(maxMiddle, r - l + 1);
        }
        return s.length() - maxMiddle;
    }
}
