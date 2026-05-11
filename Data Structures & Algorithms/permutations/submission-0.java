class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,result,new ArrayList<>(),new boolean[nums.length]);
        return result;
    }
    private static void backtrack(int[] nums,List<List<Integer>> result,
    List<Integer> curr,boolean[] isUsed){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
        }
        for(int i=0; i<nums.length; i++){
            if(isUsed[i]){
                continue;
            }
            isUsed[i] = true;
            curr.add(nums[i]);
            backtrack(nums,result,curr,isUsed);
            isUsed[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}
