class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res= new HashSet<>();
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        dfs(0,target,candidates,res,curr);
        return new ArrayList<>(res);
    }
    private static void dfs(int i,int target,int[] candidates,
     Set<List<Integer>> res, List<Integer> curr){
  
        if(target == 0){
            res.add(new ArrayList<>(curr));
        }
        if(target < 0 || i >= candidates.length){
            return;
        }

        curr.add(candidates[i]);
        dfs(i+1,target-candidates[i],candidates,res,curr);
        curr.remove(curr.size()-1);
        dfs(i+1,target,candidates,res,curr);
    }
}
