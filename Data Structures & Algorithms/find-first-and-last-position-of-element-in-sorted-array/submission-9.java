class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        int[] res = new int[]{-1,-1};

        // first occur
        while(l<=r){
            int m = l + (r-l)/2;
            if(nums[m] >= target){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        if(l >= nums.length || nums[l] != target){
            return res;
        }
        res[0] = l;

        //reset
        l = 0;
        r = nums.length - 1;


        // last occur
        while (l <= r) {
            int m = l + (r-l)/2;
            if(nums[m] <= target){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        res[1] = r;

        return res;
    }
}