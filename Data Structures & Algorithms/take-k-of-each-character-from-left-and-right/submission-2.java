class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0)
            return 0;
        int maxWindow = 0;
        int[] total = new int[3];

        for (int i = 0; i < s.length(); i++) {
            total[s.charAt(i) - 'a']++;
        }

        if (total[0] < k || total[1] < k || total[2] < k) {
            return -1;
        }

        int[] window = new int[3];

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char cr = s.charAt(r);
            window[cr - 'a']++;

            while (total[cr - 'a'] - window[cr - 'a'] < k) {
                char cl = s.charAt(l);
                window[cl - 'a']--;
                l++;
            }
            maxWindow = Math.max(maxWindow, (r - l + 1));
        }
        return s.length() - maxWindow;
    }
}
