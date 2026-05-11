class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        
        for(int n:set){
            if(set.contains(n-1)){
                continue;
            }else{
                int freq = 1;
                while(set.contains(n+freq)){
                    freq++;
                }
                res = Math.max(res,freq);
            }
        }
        return res;
    }
}
