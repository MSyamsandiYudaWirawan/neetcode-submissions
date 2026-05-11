class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l=0
        result = 0

        for r in range(len(prices)):
            profit = 0
            if prices[r]>prices[l]:
                profit = prices[r]-prices[l]
                result = max(result,profit)
            else:
                l=r
        return result
        