class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int max = 0;
        for(int n:nums){
            int freq = 1;
            while(set.contains(n+freq)){
                freq++;
            }
            max = Math.max(max,freq);
        }
        return max;
    }
}
