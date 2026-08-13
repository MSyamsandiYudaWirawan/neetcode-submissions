class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[] {-1, -1};
        int i = -1;

        int firstOccur = -1;
        int lastOccur = -1;

        while (l <= r) {
            firstOccur = l + (r - l) / 2;
            if (nums[firstOccur] >= target) {
                r = firstOccur - 1;
            } else {
                l = firstOccur + 1;
            }
        }
        if (l >= nums.length || nums[l] != target) {
            return res;
        }

        res[0] = l;

        l = 0;
        r = nums.length - 1;

        while (l <= r) {
            lastOccur = l + (r - l) / 2;
            if (nums[lastOccur] <= target) {
                l = lastOccur + 1;
            } else {
                r = lastOccur - 1;
            }
        }
        res[1] = r;

        return res;
    }
}