class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> cur = new LinkedHashSet();
        dfs(nums, cur);
        return res;
    }
    private void dfs(int[] nums, Set<Integer> cur) {
        if (nums.length == cur.size()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(cur.contains(nums[i])){
                continue;
            }
            cur.add(nums[i]);
            dfs(nums,cur);
            cur.remove(nums[i]);
        }
    }
}
