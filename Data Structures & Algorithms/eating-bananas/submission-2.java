class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = findMaxP(piles);
        int res= 0;
        while(l<=r){
            int k = (r-l)/2 + l;
            long totalTime = 0;
            for(int p:piles){
                totalTime += Math.ceil((double) p / k);
            }
            if(totalTime <= h){
                res = k;
                r = k - 1;
            }else {
                l = k + 1;
            }
        }
        return res;
        
    }
    private int findMaxP(int[] piles){
        int max = 0;
        for(int p: piles){
            if(max<p){
                max = p;
            }
        }
        return max;
    }
}
