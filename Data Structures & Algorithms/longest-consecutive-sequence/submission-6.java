class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int maxCount = 0;

        for(int n:nums){
            set.add(n);
        }
        for(int n:set){
            if(!set.contains(n-1)){
                int count = 0;
                while(set.contains(n+count)){
                    count++;
                }
                maxCount = Math.max(maxCount,count);
            }
        }
        return maxCount;
    }
}
