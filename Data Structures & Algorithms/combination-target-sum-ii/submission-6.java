class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        dfs(candidates, target, 0, cur, 0);
        return res;
    }
    private void dfs(int[] nums, int target, int i, List<Integer> cur, int sum) {
        if (target == sum) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            if (sum + nums[j] > target) {
                break;
            }
            cur.add(nums[j]);
            dfs(nums, target, j + 1, cur, sum + nums[j]);
            cur.remove(cur.size() - 1);
        }
    }
}
