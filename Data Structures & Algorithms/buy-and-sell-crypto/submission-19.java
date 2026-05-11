class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int l = 0;
        for(int r = 1; r<prices.length; r++){
            int profit = 0;
            if(prices[l] < prices[r]){
                profit = prices[r] - prices[l];
            }
            else{
                l = r;
            }
            res = Math.max(res,profit);
        }
        return res;
    }
}
