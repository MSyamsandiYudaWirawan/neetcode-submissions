class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        //a = distance start 0 to start cycle
        //b = distance intersection to start cycle
        //and a = b
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast){
                break;
            }
        }
        // fins start cycle
        int slow2 = 0;
        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2){
                return slow;
            }
        }

    }
}
