class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = 1;
        }
        int leftProduct = 1;
        for(int i=0; i<nums.length;i++){
            arr[i]*=leftProduct;
            leftProduct *= nums[i];
            
        }
        int rightProduct=1;
        for(int i=nums.length-1; i>=0;i--){
            arr[i]*=rightProduct;
            rightProduct *= nums[i];
            
        }
        return arr;

    }
}  
