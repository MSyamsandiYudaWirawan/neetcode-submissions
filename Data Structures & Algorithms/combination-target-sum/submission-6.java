class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, cur, 0);
        return res;
    }
    private void dfs(int[] nums, int target, int idx, List<Integer> cur, int sum) {
        if(target == sum){
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if(sum + nums[i] > target){
                break;
            }
            cur.add(nums[i]);
            dfs(nums, target, i, cur, sum + nums[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
