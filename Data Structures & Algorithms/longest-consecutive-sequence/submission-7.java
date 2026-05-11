class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for(int num:nums){
            set.add(num);
        }
        for(int num:nums){
            if(set.contains(num)){
                int freq = 1;
                while(set.contains(num-freq)){
                    freq++;
                }
                max = Math.max(freq,max);
            }
        }
        return max;

    }
}
