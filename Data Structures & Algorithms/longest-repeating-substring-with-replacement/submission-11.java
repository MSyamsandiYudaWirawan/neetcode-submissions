class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char cr = s.charAt(r);
            map.merge(cr, 1, Integer::sum);
            maxCount = Math.max(maxCount, map.get(cr));

            while ((r - l + 1) > k + maxCount) {
                char cl = s.charAt(l);
                if (map.get(cl) > 0) {
                    map.merge(cl, -1, Integer::sum);
                } else {
                    map.remove(cl);
                }
                l++;
            }
            res = Math.max(res, (r - l + 1));
        }
        return res;
    }
}
