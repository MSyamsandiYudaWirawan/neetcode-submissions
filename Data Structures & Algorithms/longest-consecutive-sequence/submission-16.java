class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int n:nums){
            set.add(n);
        }

        for(int n:set){
            if(set.contains(n-1)){
                continue;
            }else{
                int maxFreq = 1;
                while(set.contains(n+maxFreq)){
                    maxFreq++;
                }
                res = Math.max(res, maxFreq);
            }
        }
        return res;
    }
}
