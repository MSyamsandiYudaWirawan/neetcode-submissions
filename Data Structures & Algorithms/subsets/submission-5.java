class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset) {
        if (i >= nums.length) {
            res.add(new ArrayList(subset));
            return;
        }
        // include num i
        subset.add(nums[i]);
        // explore num i+1
        dfs(nums, i + 1, subset);
        // undo bcs we already explore it
        subset.remove(subset.size() - 1);
        // after undo explore next path i + 1
        dfs(nums, i + 1, subset);
    }
}
