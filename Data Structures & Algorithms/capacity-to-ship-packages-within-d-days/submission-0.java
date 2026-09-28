class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int l = 0;
        int r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r = r + w;
        }
        while (l < r) {
            int cap = l + (r - l) / 2;
            int daysNeeded = 1;
            int remaining = cap;

            for (int w : weights) {
                if (w > remaining) {
                    daysNeeded++;
                    remaining = cap;
                }
                remaining -= w;
            }

            if (daysNeeded <= days) {
                r = cap;
            } else {
                l = cap + 1; 
            }
        }
        return l;
    }
}