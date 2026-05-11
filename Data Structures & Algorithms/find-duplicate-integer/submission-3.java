class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        //floyd algorithm
        //first find intersection
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        //after first intersection
        //find startcycle with slow2 from start
        // a = before start cycle
        // b = intersection before start cycle
        // and a = b
        int slow2 = 0;
        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow==slow2){
                return slow;
            }
        }

    }
}
