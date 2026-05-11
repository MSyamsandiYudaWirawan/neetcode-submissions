class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(0,target,nums,res,curr);
        return res;

     }
     private static void dfs(int i,int target,int[] nums,
      List<List<Integer>> res, List<Integer>curr){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target<0 || i>=nums.length){
            return;
        }
        curr.add(nums[i]);
        dfs(i,target-nums[i],nums,res,curr);
        curr.remove(curr.size()-1);
        dfs(i+1,target,nums,res,curr);
     }
}
