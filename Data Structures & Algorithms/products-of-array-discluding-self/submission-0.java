class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int leftProduct  = 1;
        int rightProduct = 1;

        for(int i=0;i<n;i++){
            result[i]=1;
        }
        for(int i=0; i<n; i++){
            if(i==0){
                leftProduct = 1;
                result[i] *= leftProduct;
            }
            else{
                leftProduct *= nums[i-1];
                result[i] *= leftProduct;
            }
        }

        for(int i = n-1; i >= 0; i--){
            if(i == n-1){
                rightProduct = 1;
                result[i] *= rightProduct;
            }
            else{
                rightProduct *= nums[i+1];
                result[i] *= rightProduct;
            }
        }
        return result;
        
    }
}  
