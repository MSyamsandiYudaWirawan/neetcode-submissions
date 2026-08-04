class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        dfs(candidates, target, cur, 0, 0);
        return res;
    }
    private void dfs(int[] nums, int target, List<Integer> cur, int idx, int sum) {
        if (target == sum) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < sum || idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if(i>idx && nums[i] == nums[i-1]){
                continue;
            }
            if (sum + nums[i] > target) {
                break;
            }
            cur.add(nums[i]);
            dfs(nums, target, cur, i + 1, sum + nums[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
