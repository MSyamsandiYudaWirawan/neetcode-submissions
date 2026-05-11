class Solution {
    public int findDuplicate(int[] nums) {
        // use floyd alg
        // slow and fast pointer
        // if it meet create new slow2 pointer from start
        // shift boot slow2 and slow
        // if meet return that index 
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast){
                break;
            }
        } 
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
