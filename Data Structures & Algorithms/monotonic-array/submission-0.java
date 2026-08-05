class Solution {

    public boolean isMonotonic(int[] nums) {
        boolean decrease = true;
        boolean increase = true;

        for(int i=0; i<nums.length - 1; i++){
            if(!(nums[i] <= nums[i+1])){
                increase = false;
            }
            if(!(nums[i] >= nums[i+1])){
                decrease = false;
            }
        }
        return increase || decrease;
        
    }
}