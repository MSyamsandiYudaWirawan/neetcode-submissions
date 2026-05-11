class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int n=numbers.length; 
        int r=n-1;

        while(l<r){
            int sum = numbers[l] + numbers[r];
            if(sum > target){
                r--;
            }
            else if(sum < target){
                l++;
            }
            else {
                return new int[]{l+1,r+1};
            }
        }
        return new int[] {};
    }
}
