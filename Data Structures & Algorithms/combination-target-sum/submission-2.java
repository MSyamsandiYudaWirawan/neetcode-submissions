class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur = new ArrayList<>();
        dfs(nums, target, 0, cur);
        return res;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> cur) {
        // target match add copies to res;
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        // no need explore
        if (target < 0 || i >= nums.length) {
            return;
        }
        // add num i to curr
        cur.add(nums[i]);
        // explore same num and substract target(because we add it in cur)
        dfs(nums, target - nums[i], i, cur);
        // backtrack
        cur.remove(cur.size() - 1);
        // skip i(because its already explored) try next number instead i + 1
        dfs(nums, target, i + 1, cur);
    }
}
