class Solution {
    public int findDuplicate(int[] nums) {
        int s = 0;
        int f = 0;
        while(true){
            f = nums[nums[f]];
            s = nums[s];
            if(s == f){
                break;
            }
        }   
        int s2 = 0;
        while(true){
            s = nums[s];
            s2 = nums[s2];
            if(s==s2){
                return s;
            }
        }
    }
}
