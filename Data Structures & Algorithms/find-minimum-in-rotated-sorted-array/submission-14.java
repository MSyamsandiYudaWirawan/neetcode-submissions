class Solution {
    public int findMin(int[] nums) {
        //find n is in left part or right part
        // shift it to smaller part
        int l=0;
        int r = nums.length - 1;
        int res = nums[0];

        while(l<=r){
            if(nums[l] <= nums[r]){
                //sorted arr
                res = Math.min(res,nums[l]);
            }
            int m = l + (r-l)/2;
            res = Math.min(res,nums[m]);
            //left part shift to right
            if(nums[l] <= nums[m]){
                l = m + 1;
            }else{
                //right part shift to left
                r = m - 1;
            }
        }
        return res;
    }
}
