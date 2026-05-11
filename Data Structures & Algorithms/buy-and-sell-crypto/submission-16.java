class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int l = 0;
        for(int r=0; r<prices.length; r++){
            int profit = prices[r] - prices[l];
            if(profit > 0){
                res = Math.max(res,profit);
            }
            else{
                l = r;
            }
        }
        return res;
    }
}
