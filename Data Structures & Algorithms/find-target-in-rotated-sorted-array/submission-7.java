class Solution {
    public int search(int[] nums, int target) {
        // find target is in left part or right part
        // do binary search in left or right part
        int l = 0;
        int r = nums.length - 1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(nums[m] == target){
                return m;
            }
            //left part
            if(nums[l] <= nums[m]){

                if(target < nums[m] && target >= nums[l]) {
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }else{
                if(target > nums[m]  && target <= nums[r]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
