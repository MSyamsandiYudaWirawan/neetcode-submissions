class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];

        int res = 0;
        while (l < r) {
            if (height[r] > height[l]) {
                l++;
                maxL = Math.max(maxL, height[l]);
                res = res + (maxL - height[l]);
            } else {
                r--;
                maxR = Math.max(maxR, height[r]);
                res = res + (maxR - height[r]);
            }
        }

        return res;
    }
}
