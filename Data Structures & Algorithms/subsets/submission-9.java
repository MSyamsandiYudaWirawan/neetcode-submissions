class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, 0, cur);
        return res;
    }
    private void backtrack(int[] nums, int idx, List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        if (idx >= nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(nums, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
