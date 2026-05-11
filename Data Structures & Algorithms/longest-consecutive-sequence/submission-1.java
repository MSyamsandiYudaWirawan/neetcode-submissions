class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> count = new ArrayList<>();
        for(int num:nums){
            set.add(num);
        }
        for(int num:nums){
            if(!set.contains(num-1)){
                int freq = 1;
                while(set.contains(num+freq)){
                    freq++;
                }
                count.add(freq);
            }
        }
        return Collections.max(count);
    }
}
