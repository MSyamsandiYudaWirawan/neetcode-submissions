class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        dfs(nums, target, cur, 0, 0);
        return res;
    }
    private void dfs(int[] nums, int target, List<Integer> cur, int sum, int idx) {
        if (target == sum) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = idx; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                break;
            }
            cur.add(nums[i]);
            dfs(nums, target, cur, sum + nums[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}
