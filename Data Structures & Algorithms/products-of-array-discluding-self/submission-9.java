class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = 1;
        }
        int leftProd = 1;
        for(int i=0;i<n;i++){
            res[i]*=leftProd;
            leftProd*=nums[i];
        }

        int rightProd=1;
        for(int i=n-1; i>=0; i--){
            res[i]*=rightProd;
            rightProd*=nums[i];
        }
        return res;
    }
}  
