class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        dfs(candidates, target, cur, 0, 0);
        return res;
    }
    private void dfs(int[] nums, int target, List<Integer> cur, int sum, int idx) {
        if (target == sum) {
            res.add(new ArrayList<>(cur));
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
            dfs(nums, target, cur, sum + nums[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
