class Solution {
    public int maxProfit(int[] prices) {
       int l = 0;
       int result = 0;
       for(int r=1 ;r<prices.length; r++){
        int sum=0;
        if(prices[l]>prices[r]){
            l = r;
            continue;
        }
        sum = prices[r] - prices[l];
        result = Math.max(sum,result);
       }
       return result;

       
    }   
}
