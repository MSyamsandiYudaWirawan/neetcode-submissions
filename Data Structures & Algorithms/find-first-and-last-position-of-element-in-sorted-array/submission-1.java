class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[]{-1, -1};
        int i = -1;
        

        while(l <= r){
            int m = l + (r-l) / 2;

            if(nums[m] > target){
                r = m - 1;
            }else if(nums[m] < target){
                l = m + 1;
            }else{
                int start = m;
                int end = m;
                while(start > 0 && nums[start] == nums[start - 1]){
                    start--;
                }
                while(end < nums.length - 1 && nums[end] == nums[end + 1]){
                    end++;
                }
                res[0] = start;
                res[1] = end;
                break;
            }
        }
        return res;


    }
}