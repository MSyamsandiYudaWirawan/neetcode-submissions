class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur = new ArrayList<>();
        dfs(nums, target, 0, cur);
        return res;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> cur) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (i >= nums.length || target < 0) {
            return;
        }
        cur.add(nums[i]);
        dfs(nums, target - nums[i], i, cur);
        cur.remove(cur.size() - 1);
        dfs(nums, target, i + 1, cur);
    }
}
