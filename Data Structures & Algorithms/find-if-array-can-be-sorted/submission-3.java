class Solution {
    public boolean canSortArray(int[] nums) {
        int prevMax = 0;
        int groupMax = 0;
        int prevBits = -1;

        for (int val : nums) {
            int bits = Integer.bitCount(val);

            if (bits != prevBits) {
                // close curr group
                prevMax = Math.max(prevMax, groupMax);

                //start new group
                groupMax = val;
                prevBits = bits;
            } else {
                groupMax = Math.max(groupMax, val);
            }
            if (val < prevMax)
                return false;
        }
        return true;
    }
}
