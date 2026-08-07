class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur = new ArrayList<>();

        backtrack(nums, target, 0, cur, 0);
        return res;
    }
    private void backtrack(int[] nums, int target, int sum, List<Integer> cur, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(cur));
        }
        if (target < sum || idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(nums, target, sum + nums[i], cur, i);
            cur.remove(cur.size() - 1);
        }
    }
}
