class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int result = 0;

        for(; right < prices.length; right++){
            int profit = 0;
            if(prices[right] > prices[left]){
                profit = prices[right] - prices[left];
            }
            else{
                left = right;
            }
            result = Math.max(result, profit);
        }
        return result;
    }
}
