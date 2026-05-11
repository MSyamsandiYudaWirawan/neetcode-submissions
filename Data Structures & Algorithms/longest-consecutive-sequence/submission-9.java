class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for(int num:nums){
            set.add(num);
        }

        for(int num:nums){
            int i=1;
            while(set.contains(num-i)){
                i++;
            }
            max = Math.max(max,i);
        }
        return max;
    }
}
