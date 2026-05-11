class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int max=0;
        for(int i=0; i<nums.length; i++){
            int freq=0;
            while(set.contains(nums[i]-freq)){
                freq++;
            }
            max = Math.max(freq,max);
        }
        return max;
    }
}
