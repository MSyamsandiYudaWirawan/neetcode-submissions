class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            prod[i] = 1;
        }
        int leftProd = 1;
        for(int i=0; i < nums.length; i++){
            prod[i]*=leftProd;
            leftProd*= nums[i];
        }

        int rightProd = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            prod[i]*=rightProd;
            rightProd*=nums[i];
        }
        return prod;
    }
}  
