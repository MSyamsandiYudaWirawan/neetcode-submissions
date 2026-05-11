class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for(int n:nums){
            set.add(n);
        }
        for(int i=0; i<nums.length; i++){
            int freq = 1;
            while(set.contains(nums[i]-freq)){
                freq++;
            }
            res = Math.max(freq,res);
        }
        return res;

    }
}
