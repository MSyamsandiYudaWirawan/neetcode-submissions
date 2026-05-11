class Solution {
    public int maxProfit(int[] prices) {
       int l=0;
       int result =0;

       for(int r=0;r<prices.length;r++){
        int profit=0;
        while(prices[r]-prices[l]<0){
            l++;
        }
        profit = prices[r]-prices[l];
        result = Math.max(profit,result);
       }
       return result;

       
    }   
}
