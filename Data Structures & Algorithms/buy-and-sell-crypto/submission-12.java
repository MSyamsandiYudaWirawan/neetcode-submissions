class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int result = 0;

        while(r<prices.length){
            int profit = 0;
            if(prices[r] - prices[l]>0){
                profit = prices[r] - prices[l];
            }else{
                l=r;
            }
            result = Math.max(result,profit);
            r++;
        }
        return result;

       
    }   
}
