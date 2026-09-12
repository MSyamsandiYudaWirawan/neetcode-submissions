class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = maxPile(piles);

        int l = 1;
        int r = maxK;
        int res = maxK;

        while (l <= r) {
            int k = (r - l) / 2 + l;
            long time = 0;
            for (int p : piles) {
                time += ((long) p + k - 1)/k;
            }
            // valid
            if (time <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }
    private int maxPile(int[] piles) {
        int n = 0;
        for (int p : piles) {
            if (n < p) {
                n = p;
            }
        }
        return n;
    }
}
