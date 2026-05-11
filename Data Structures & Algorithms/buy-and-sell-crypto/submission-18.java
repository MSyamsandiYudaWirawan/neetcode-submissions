class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int l=0;
        for(int r=0;r<prices.length;r++){
            int profit = 0;
            if(prices[r]>prices[l]){
                profit = prices[r] - prices[l];
            }
            else {
                l = r;
            }
            res = Math.max(res,profit);
        }
        return res;
    }
}
