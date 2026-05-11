class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l = 0
        r = 0
        result = 0

        for r in range(len(prices)):
            profit = 0
            if prices[r] > prices[l]:
                profit = prices[r] - prices[l]
            else:
                l=r
            result = max(result,profit)
        return result
            
            
        