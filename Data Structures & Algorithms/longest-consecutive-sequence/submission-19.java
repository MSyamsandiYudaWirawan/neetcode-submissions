class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }
        int res = 0;

        for (int n : set) {
            if (!set.contains(n - 1)) {
                int freq = 1;
                while (set.contains(n + freq)) {
                    freq++;
                }
                res = Math.max(freq,res);
            }
        }
        return res;
    }
}
