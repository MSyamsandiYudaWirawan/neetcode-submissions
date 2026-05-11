class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prodArr = new int[nums.length];

        for(int i=0;i<nums.length; i++){
            prodArr[i] = 1;
        } 

        int leftProd = 1;
        for(int i=0 ;i< nums.length; i++){
            prodArr[i] *= leftProd;
            leftProd *= nums[i];
        } 

        int rightProd = 1;
        for(int i=nums.length-1; i>=0;i--){
            prodArr[i] *= rightProd;
            rightProd *= nums[i];
        }

        return prodArr;

    }
}  
