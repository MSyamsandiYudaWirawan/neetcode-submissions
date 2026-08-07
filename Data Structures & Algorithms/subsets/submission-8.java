class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> cur = new ArrayList<>();
        backtrack(nums, cur, 0);
        return res;
    }
    private void backtrack(int[] nums, List<Integer> cur, int idx) {
        res.add(new ArrayList<>(cur));
        if (idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {   

            cur.add(nums[i]);
            backtrack(nums, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
