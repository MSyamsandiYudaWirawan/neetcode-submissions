class Solution {
    public int longestConsecutive(int[] nums) {
        int maxFreq = 0;
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        for(int n:set){
            if(!set.contains(n-1)){
                int freq = 1;
                while(set.contains(n+freq)){
                    freq++;
                }
                maxFreq = Math.max(maxFreq,freq);
            }
        }
        return maxFreq;
    }
}
