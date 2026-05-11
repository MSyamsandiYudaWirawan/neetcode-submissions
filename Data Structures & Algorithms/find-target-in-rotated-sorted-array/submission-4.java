class Solution {
    public int search(int[] nums, int target) {
        //split to 2 part asc array
        // find with binary search
        int l = 0;
        int r = nums.length - 1;

        while(l<=r){
            int m = (r-l)/2 + l;
            if(nums[m]==target){
                return m;
            }
            if(nums[l] <= nums[m]){
                //m in the left part
                if(nums[l] <= target && target <= nums[m]){
                    // if target in the left part shit to the left
                    r = m - 1;
                }else{
                    l = m + 1;
                }

            }else{
                // m in the right part
                if(nums[m] <= target && target <= nums[r]){
                    // if target in the right part shit to the right
                    l = m+1;
                }else{
                    r = m-1;
                }
            }
        }
        return -1;
    }
}
