class Solution {
    public boolean hasDuplicate(int[] nums) {
       Set<Integer> hashSet = new HashSet<>();
       for(int n : nums ){
        if(hashSet.contains(n)){
            return true;
        }
        hashSet.add(n);
       }
       return false;
    }
}
