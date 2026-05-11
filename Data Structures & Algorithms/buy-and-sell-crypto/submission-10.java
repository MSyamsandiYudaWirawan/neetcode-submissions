class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int result = 0;

        while(right < prices.length){
            int profit = 0;

            if(prices[right] - prices[left] < 0){
                left = right;
            }
            else{
                profit = prices[right] - prices[left];
                result = Math.max(profit, result); 
                
            }
            right++;
        }
        return result;
    }   
}
