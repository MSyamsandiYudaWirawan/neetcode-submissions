class Solution {
    public int search(int[] nums, int target) {
       int n = nums.length;
       int l = 0;
       int r = n-1;

        while(l<=r){
            int m = (r-l)/2 + l;
            if(nums[m] < target){
                l = m + 1;
            }
            else if(nums[m] > target){
                r = m - 1;
            }
            else{
                return m;
            }
        }
        return -1;        
    }
}
