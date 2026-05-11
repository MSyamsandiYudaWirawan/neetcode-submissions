class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){

            if(i > 0 && nums[i]==nums[i-1]){
                continue;
            }

            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = nums[l] + nums[i] + nums[r];

                if(sum > 0){
                    r--;
                }
                else if(sum < 0){
                    l++;
                }
                else{
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));

                    if(l<r && nums[l] == nums[l+1]){
                        l++;
                    }
                    if(l<r && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return result;
    }
}
