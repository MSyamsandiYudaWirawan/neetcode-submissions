class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r = nums.length - 1;
        int res = nums[0];

        while(l<=r){
            if(nums[l] < nums[r]){
                res = Math.min(res,nums[l]);
                return res;
            }
            int m = (r-l)/2 + l;
            res = Math.min(res,nums[m]);
            //e.g. 4,5,6,1,2,3
            if(nums[l] <= nums[m]){
                // m in bigger part shift to the right
                l = m + 1;
            }else{
                // m in smaller part shift to the left
                r = m - 1;
            }
        }
        return res;
    }
}
